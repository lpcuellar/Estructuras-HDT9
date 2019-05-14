import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String [] args) throws IOException {

        Scanner input = new Scanner(System.in);

        String mainMenu = "     --- RUTAS PARA GIRAS --- \n" +
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
                    // Leer el archivo .txt
                    System.out.print("Ingrese el archivo de texto que desea leer: ");
                    String userFile = input.nextLine();
                    userFile = input.nextLine();

                    try {
                        Stream<String> lines = Files.lines(
                                Paths.get(userFile),
                                StandardCharsets.UTF_8
                        );


                        lines.forEach(line -> {
                            String[] routes = line.toUpperCase().split(",");
                            System.out.println(Arrays.toString(routes));
                        });
                    }

                    catch (Exception e) {
                        System.out.println("No se ha encontrado ningun archivo con ese nombre");
                    }
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                default:
                    System.out.print(" *** Ingrese una opción válida! *** \n");
                    break;
            }
        }

        System.out.println("Gracias por usar el programa <3\n");
    }
}
