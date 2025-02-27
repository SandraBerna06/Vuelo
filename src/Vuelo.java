import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Vuelo {
    String numero;
    String origen;
    String destino;
    LocalDate dia;
    String clase;

    public Vuelo(String numero, String origen, String destino, LocalDate dia, String clase) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.dia = dia;
        this.clase = clase;
    }

    public String getNumero() {
        return numero;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getDia() {
        return dia;
    }

    public String getClase() {
        return clase;
    }

    public static void printDatos(ArrayList<Vuelo> numeroVuelos) {

        if (numeroVuelos.isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            for (Vuelo vuelos : numeroVuelos) {
                System.out.println("Imprimir vuelos:\n");
                System.out.println("-Número: " + vuelos.getNumero() + " Origen: " + vuelos.getOrigen() + " Destino: " + vuelos.getDestino() + " Día: " + vuelos.getDia() + " Clase: " + vuelos.getClase());
            }
        }

    }

    public static void mostrarDatos(ArrayList<Vuelo> numeroVuelos, String numero) {
        if (numeroVuelos.isEmpty()) {
            System.out.println("No se pueden mostar los datos");
            return;
        }
            for (Vuelo vuelos : numeroVuelos) {
                if (vuelos.getNumero().equalsIgnoreCase(numero)) {
                    System.out.println("- Número: " + vuelos.getNumero() +
                            " | Origen: " + vuelos.getOrigen() +
                            " | Destino: " + vuelos.getDestino() +
                            " | Dia: " + vuelos.getDia() +
                            " | Clase: " + vuelos.getClase());
return;


            }
        }
        System.out.println("No se ha encontrado");
    }

    public static void buscarClave(ArrayList<Vuelo> numeroVuelos, int opcion2, String valor) {
        boolean correcta = false;
        if (numeroVuelos.isEmpty()) {
            System.out.println("La lista está vacía");
            return;
        }

        boolean encontrado=true;

        for (Vuelo vuelo : numeroVuelos) {
            boolean coincide = true;

            switch (opcion2) {
                case 1:
                    coincide = vuelo.getOrigen().equalsIgnoreCase(valor);
                    break;
                case 2:
                    coincide = vuelo.getDestino().equalsIgnoreCase(valor);
                    break;
                case 3:
                    coincide = vuelo.getDia().equals(valor);
                    break;
                case 4:
                    coincide = vuelo.getClase().equalsIgnoreCase(valor);
                    break;
                default:
                    System.out.println("Error: Clave inválida. Usa: origen, destino, día, clase.");
                    return;
            }

            if (coincide) {
                System.out.println("- Número: " + vuelo.getNumero() +
                        " | Origen: " + vuelo.getOrigen() +
                        " | Destino: " + vuelo.getDestino() +
                        " | Fecha: " + vuelo.getDia() +
                        " | Clase: " + vuelo.getClase());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron vuelos con " + opcion2 + " = " + valor);
        }

    }

    public static void addNewVuelo(ArrayList<Vuelo> numeroVuelos){
        Scanner scanner=new Scanner(System.in);

        System.out.println("Introduce el numero de vuelo");
        String numeroVuelo= scanner.nextLine();

        System.out.println("Introduce el origen");
        String origen= scanner.nextLine();

        System.out.println("Introduce el destino");
        String destino= scanner.nextLine();

        System.out.println("Introduce el año");
        int año= scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduce el mes");
        int mes= scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduce el día");
        int dia=scanner.nextInt();
        scanner.nextLine();

        LocalDate fechaVuelo = LocalDate.of(año, mes, dia);

        System.out.println("Introduce la clase (primera/turista)");
        String clase= scanner.nextLine();

        numeroVuelos.add(new Vuelo(numeroVuelo,origen,destino,fechaVuelo,clase));

        System.out.println("Vuelo añadido con éxito");
    }

    public static void findVuelo(ArrayList<Vuelo> numeroVuelos, String numeroIntrod){


        if(numeroVuelos.isEmpty()){
            System.out.println("La lista está vacía");
            return;
        }
        boolean encontrado = false;

        for (Vuelo vuelo : numeroVuelos) {
            if (vuelo.getNumero().equalsIgnoreCase(numeroIntrod)) {
                System.out.println("Vuelo encontrado:");
                System.out.println("- Número: " + vuelo.getNumero() +
                        " | Origen: " + vuelo.getOrigen() +
                        " | Destino: " + vuelo.getDestino() +
                        " | Día: " + vuelo.getDia() +
                        " | Clase: " + vuelo.getClase());
                encontrado = true;
                numeroVuelos.remove(vuelo);
                System.out.println("Vuelo eliminado con éxito");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un vuelo con el número: " + numeroIntrod);
        }

        }

        public static void acabar(){
            System.out.println("Saliendo del programa....");
        }
    }

