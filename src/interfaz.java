import java.util.Scanner;

public class interfaz {
    public static void main(String[] args) {
        String host = " ";
        Scanner sc = new Scanner(System.in);

        while (!host.equalsIgnoreCase("salir")){
            System.out.printf("Intruduce el host o IP (o 'salir' para terminar): ");
            host = sc.nextLine();

            if (!host.equalsIgnoreCase("salir")){
                lanzador.ejecutarPing(host);
            }
        }
        sc.close();
        System.out.println("Programa terminado.");
    }
}