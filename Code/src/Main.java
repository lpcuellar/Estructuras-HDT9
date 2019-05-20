import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public static void main(String [] args) throws IOException {

        Scanner input = new Scanner(System.in);
        ArrayList<Routes> routes = new ArrayList<>();
        Map<String, Integer> cities = new HashMap<String, Integer>();
        FloydA algorithm = new FloydA();
        Matrix matriz = new Matrix(cities.size());

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
        int position= 0;

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

                              if (!cities.containsKey(origen)) {
                                  cities.put(origen, position);
                                  position += 1;
                              }

                            }
                        }

                    } catch (IOException e) {
                        System.err.format("IOException: %s%n", e);
                    }


                    System.out.println("Las rutas han sido agregadas con éxito!");

                    int number_of_vertices = cities.size();
                    int count = 1;
                    int index = 0;
                    int lugar = 0;
                    int intSource = 0;
                    int intDestination = 0;
                    int intDistance = 0;
                    int number_of_edges = 784;

                    while (count <= number_of_edges) {

                        intSource = index;
                        if (intSource != number_of_vertices) {
                            intDestination = lugar;

                            if (lugar == number_of_vertices) {
                                lugar = 0;
                                index += 1;
                            } else {
                                lugar += 1;
                            }
                        }

                        for (int i = 0; i < routes.size(); i++) {
                            Routes x = routes.get(i);

                            String bingo = "IDC";
                            String eureca = "IDK";

                            for (Map.Entry<String, Integer> entry : cities.entrySet()) {
                                if (entry.getValue().equals(intSource)) {
                                    bingo = entry.getKey();
                                }

                            }

                            if (x.getSource().equals(bingo)) {
                                for (Map.Entry<String, Integer> entry : cities.entrySet()) {
                                    if (entry.getValue().equals(intDestination)) {
                                        eureca = entry.getKey();
                                    }

                                }

                                if (x.getDestination().equals(eureca)) {
                                    intDistance = x.getDistance();
                                    System.out.println(intDistance);
                                    i = routes.size();
                                }
                            }
                        }

                        matriz.setEdge(intSource, intDestination, intDistance);
                        count += 1;
                    }

                    break;

                case 2:
                    System.out.println("Ingrese la ciudad en la que quiere que inicie su ruta: ");
                    String source = input.next();

                    System.out.println("Ingrese la ciudad en la que quiere que termine su ruta: ");
                    String destination = input.next();

                    /* Calcular la ruta mas corta entre ambas ciudades */
                    /* Usar algoritmo de Floyd */

                    number_of_vertices = cities.size();
                    count = 1;
                    index = 0;
                    lugar = 0;
                    intSource = 0;
                    intDestination = 0;
                    intDistance = 0;
                    number_of_edges = 784;

                    while (count <= number_of_edges) {

                        intSource = index;
                        if (intSource != number_of_vertices) {
                            intDestination = lugar;

                            if (lugar == number_of_vertices) {
                                lugar = 0;
                                index += 1;
                            } else {
                                lugar += 1;
                            }
                        }

                        for (int i = 0; i < routes.size(); i++) {
                            Routes x = routes.get(i);

                            String bingo = "IDC";
                            String eureca = "IDK";

                            for (Map.Entry<String, Integer> entry : cities.entrySet()) {
                                if (entry.getValue().equals(intSource)) {
                                    bingo = entry.getKey();
                                }

                            }

                            if (x.getSource().equals(bingo)) {
                                for (Map.Entry<String, Integer> entry : cities.entrySet()) {
                                    if (entry.getValue().equals(intDestination)) {
                                        eureca = entry.getKey();
                                    }

                                }

                                if (x.getDestination().equals(eureca)) {
                                    intDistance = x.getDistance();
                                    System.out.println(intDistance);
                                    i = routes.size();
                                }
                            }
                        }

                        matriz.setEdge(intSource, intDestination, intDistance);
                        count += 1;
                    }

                    algorithm.floydWarshall(matriz);
                    break;

                case 3:
                    String centerCity = " ";
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

                            number_of_vertices = cities.size();
                            count = 1;
                            index = 0;
                            lugar = 0;
                            intSource = 0;
                            intDestination = 0;
                            intDistance = 0;
                            number_of_edges = 784;

                            while (count <= number_of_edges) {

                                intSource = index;
                                if (intSource != number_of_vertices) {
                                    intDestination = lugar;

                                    if (lugar == number_of_vertices) {
                                        lugar = 0;
                                        index += 1;
                                    } else {
                                        lugar += 1;
                                    }
                                }

                                for (int i = 0; i < routes.size(); i++) {
                                    Routes x = routes.get(i);

                                    String bingo = "IDC";
                                    String eureca = "IDK";

                                    for (Map.Entry<String, Integer> entry : cities.entrySet()) {
                                        if (entry.getValue().equals(intSource)) {
                                            bingo = entry.getKey();
                                        }

                                    }

                                    if (x.getSource().equals(bingo)) {
                                        for (Map.Entry<String, Integer> entry : cities.entrySet()) {
                                            if (entry.getValue().equals(intDestination)) {
                                                eureca = entry.getKey();
                                            }

                                        }

                                        if (x.getDestination().equals(eureca)) {
                                            intDistance = x.getDistance();
                                            System.out.println(intDistance);
                                            i = routes.size();
                                        }
                                    }
                                }

                                matriz.setEdge(intSource, intDestination, intDistance);
                                count += 1;
                            }

                            algorithm.floydWarshall(matriz);

                            break;

                        case 2:
                            System.out.println("Ingrese la ciudad origen: ");
                            sourceCity = input.next();

                            System.out.println("Ingrese la ciudad destino: ");
                            destinationCity = input.next();

                            System.out.println("Ingrese la nueva distancia entre ambas ciudades: ");
                            distanceCity = input.nextInt();

                            /* Recorrer la matriz en busca de ambas ciudades e ingresar la nueva distancia entre dos ciudades */

                            number_of_vertices = cities.size();
                            count = 1;
                            index = 0;
                            lugar = 0;
                            intSource = 0;
                            intDestination = 0;
                            intDistance = 0;
                            number_of_edges = 784;

                            while (count <= number_of_edges) {

                                intSource = index;
                                if (intSource != number_of_vertices) {
                                    intDestination = lugar;

                                    if (lugar == number_of_vertices) {
                                        lugar = 0;
                                        index += 1;
                                    } else {
                                        lugar += 1;
                                    }
                                }

                                for (int i = 0; i < routes.size(); i++) {
                                    Routes x = routes.get(i);

                                    String bingo = "IDC";
                                    String eureca = "IDK";

                                    for (Map.Entry<String, Integer> entry : cities.entrySet()) {
                                        if (entry.getValue().equals(intSource)) {
                                            bingo = entry.getKey();
                                        }

                                    }

                                    if (x.getSource().equals(bingo)) {
                                        for (Map.Entry<String, Integer> entry : cities.entrySet()) {
                                            if (entry.getValue().equals(intDestination)) {
                                                eureca = entry.getKey();
                                            }

                                        }

                                        if (x.getDestination().equals(eureca)) {
                                            intDistance = x.getDistance();
                                            System.out.println(intDistance);
                                            i = routes.size();
                                        }
                                    }
                                }

                                matriz.setEdge(intSource, intDestination, intDistance);
                                count += 1;
                            }

                            algorithm.floydWarshall(matriz);

                            break;

                        default:
                            System.out.print("Por favor ingrese una opcion valida!");
                    }
                    break;

                case 5:
                    option = 5;
                    break;

                default:
                    System.out.print(" *** Ingrese una opción válida! *** \n");
                    break;
            }
        }

        System.out.println("Gracias por usar el programa <3\n");
    }
}
