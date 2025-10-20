import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ContadorDeVocales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe un texto: ");
        String texto = sc.nextLine();
        sc.close();

        AtomicInteger totalVocales = new AtomicInteger(0);

        ContadorVocal hiloA = new ContadorVocal('a', texto, totalVocales);
        ContadorVocal hiloE = new ContadorVocal('e', texto, totalVocales);
        ContadorVocal hiloI = new ContadorVocal('i', texto, totalVocales);
        ContadorVocal hiloO = new ContadorVocal('o', texto, totalVocales);
        ContadorVocal hiloU = new ContadorVocal('u', texto, totalVocales);

        hiloA.setName("Hilo-A");
        hiloE.setName("Hilo-E");
        hiloI.setName("Hilo-I");
        hiloO.setName("Hilo-O");
        hiloU.setName("Hilo-U");

        hiloA.start();
        hiloE.start();
        hiloI.start();
        hiloO.start();
        hiloU.start();

        try {
            hiloA.join();
            hiloE.join();
            hiloI.join();
            hiloO.join();
            hiloU.join();
        } catch (InterruptedException e) {
            System.out.println("Error al esperar los hilos: " + e.getMessage());
        }

        System.out.println("\nTotal de vocales encontradas: " + totalVocales.get());
    }
}
