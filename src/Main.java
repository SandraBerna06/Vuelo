import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Vuelo> numeroVuelos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Bienvenido al gestionador de vuelos de Valencia");
        play();

    }

    public static void printMenu() {
        System.out.println("\n" +
                "---------------------------------------------------------\n" +
                "---------------------------------------------------------\n" +
                "             VUELOS DEL AEROPUERTO DE VALENCIA\n" +
                "---------------------------------------------------------\n" +
                "---------------------------------------------------------\n" +
                "1- Imprimir todos los vuelos\n" +
                "2- Buscar un número de vuelo\n" +
                "3- Buscar vuelo por clave\n" +
                "4- Añadir vuelo nuevo\n" +
                "5- Borrar vuelo por número\n" +
                "0- SALIR\n");
    }


    public static void printClaves() {
        System.out.println("Lista claves:\n" +
                "1. Origen\n" +
                "2. Destino\n" +
                "3. Dia\n" +
                "4. Clase\n");
    }


    public static void play() {

        numeroVuelos.add(new Vuelo("2023 - 01", "Valencia", "Menorca", LocalDate.of(2023, 8, 15), "turista"));
        numeroVuelos.add(new Vuelo("2023 - 02", "Valencia", "Tenerife", LocalDate.of(2023, 8, 20), "turista"));
        numeroVuelos.add(new Vuelo("2023 - 03", "Paris", "Valencia", LocalDate.of(2023, 8, 15), "primera"));
        numeroVuelos.add(new Vuelo("2023 - 04", "Atenas", "Valencia", LocalDate.of(2023, 8, 20), "primera"));

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            printMenu();
            System.out.println("Elige una opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    Vuelo.acabar();
                    break;
                case 1:
                    Vuelo.printDatos(numeroVuelos);
                    break;
                case 2:
                    System.out.println("Introduce el número de vuelo");
                    String numero= scanner.nextLine();
                    Vuelo.mostrarDatos(numeroVuelos, numero);
                    break;
                case 3:
                    printClaves();
                    System.out.println("Introduce la opcion de la clave por la que desee buscar");
                    int opcion2= scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce el valor de la clave");
                    String valor=scanner.nextLine();
                    Vuelo.buscarClave(numeroVuelos, opcion2, valor);
                    break;
                case 4:
                Vuelo.addNewVuelo(numeroVuelos);
                break;
                case 5:
                    System.out.println("Introduce el número de vuelo");
                    String numeroIntrod= scanner.nextLine();
                    Vuelo.findVuelo(numeroVuelos,numeroIntrod);
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }while (opcion != 0) ;
    }
}
