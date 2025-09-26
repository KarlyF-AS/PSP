import java.util.Scanner;

public class interfaz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String host = "";

        while (!host.equalsIgnoreCase("salir")) {
            System.out.print("Escribe un host o IP (o 'salir' para terminar): ");
            host = sc.nextLine();

            if (!host.equalsIgnoreCase("salir")) {
                lanzador.ejecutarPing(host);
            }
        }

        System.out.println("Fin del programa.");
        sc.close();
    }
