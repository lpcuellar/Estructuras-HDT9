import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String [] args) throws IOException {

        Scanner input = new Scanner(System.in);
        ArrayList<Routes> routes = new ArrayList<>();

        String mainMenu = " \n " +
                "\t     --- RUTAS PARA GIRAS --- \n" +
                "\t 1. Ingresar ciudades\n" +
                "\t 2. Indicar ciudad de origen y de destino\n" +
                "\t 3. Indicar la ciudad del centro \n" +
                "\t 4. Modificar grafo\n" +
                "\t 5. Salir del programa\n " +
                "\t Ingrese el número de la opción que desea realizar: ";

        String graphMenu = "     --- MODIFICAR EL GRAFO --- \n" +
                "\t 1. Indicar tráfico en la ruta\n" +
                "\t 2. Modificar la distancia entre dos ciudades\n" +
                "\t Ingrese el número de la opción que desea realizar: ";

        int option = 0;

        while (option != 5) {

            System.out.println(mainMenu);
            option = input.nextInt();
            System.out.print(" ");

            switch (option) {

                case 1:

                    StringBuilder sb = new StringBuilder();

                    try (BufferedReader br = Files.newBufferedReader(Paths.get("guategrafo.txt"))) {

                        // read line by line
                        String line;
                        while ((line = br.readLine()) != null) {
                            sb.append(line).append("\n");
                            String[] parts  = line.split(",");

                            if (parts.length == 3) {
                              String origen = parts[0];
                              String destino = parts[1];
                              String distancia = parts[2];

                              int dis = Integer.parseInt(distancia);
                              Routes newRout = new Routes(origen, destino, dis);
                              routes.add(newRout);
                            }

                            System.out.println("Las ciudades han sido ingresadas con exito");
                        }

                    } catch (IOException e) {
                        System.err.format("IOException: %s%n", e);
                    }

                    break;

                case 2:
                    System.out.println("Ingrese la ciudad en la que quiere que inicie su ruta: ");
                    String source = input.next();

                    System.out.println("Ingrese la ciudad en la que quiere que termine su ruta: ");
                    String destination = input.next();

                    /* Calcular la ruta mas corta entre ambas ciudades */
                    break;

                case 3:
                    String centerCity;
                    System.out.println("La ciudad del centro es : " + centerCity);
                    break;

                case 4:
                    int opcion;
                    System.out.println(graphMenu);
                    opcion = input.nextInt();

                    String sourceCity;
                    String destinationCity;
                    int distanceCity;

                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese la ciudad origen: ");
                            sourceCity = input.next();

                            System.out.println("Ingrese la ciudad destino: ");
                            destinationCity = input.next();

                            /* Ingresar infinito en la distancia entre las dos ciudades mencionadas anteriormente */
                            break;

                        case 2:
                            System.out.println("Ingrese la ciudad origen: ");
                            sourceCity = input.next();

                            System.out.println("Ingrese la ciudad destino: ");
                            destinationCity = input.next();

                            System.out.println("Ingrese la nueva distancia entre ambas ciudades: ");
                            distanceCity = input.nextInt();

                            /* Recorrer la matriz en busca de ambas ciudades e ingresar la nueva distancia entre dos ciudades */
                            break;

                        default:
                            System.out.print("Por favor ingrese una opcion valida!");
                    }
                    break;

                default:
                    System.out.print(" *** Ingrese una opción válida! *** \n");
                    break;
            }
        }

        System.out.println("Gracias por usar el programa <3\n");
    }
}
