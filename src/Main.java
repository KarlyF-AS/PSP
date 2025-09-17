import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Introduce el nombre o la ruta del archivo: ");
        String nombreRuta = sc.next();

        String editor = "gedit";
        String nombreArchivo = nombreRuta;
        String comando = "gnome-text-editor" + " " + nombreRuta;
        Runtime.getRuntime().exec(comando);
    }
}