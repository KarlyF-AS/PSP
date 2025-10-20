import java.util.concurrent.atomic.AtomicInteger;

public class ContadorVocal extends Thread {
    private char vocal;
    private String texto;
    private AtomicInteger total;

    public ContadorVocal(char vocal, String texto, AtomicInteger total) {
        this.vocal = vocal;
        this.texto = texto;
        this.total = total;
    }

    @Override
    public void run() {
        int contador = 0;

        for (int i = 0; i < texto.length(); i++) {
            char c = Character.toLowerCase(texto.charAt(i));
            if (c == vocal) {
                contador++;
                total.incrementAndGet(); // suma al total compartido
            }
        }

        System.out.println(getName() + " → Vocal '" + vocal + "': " + contador + " veces");
    }
}
