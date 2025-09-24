import java.io.BufferedReader;
import java.io.InputStreamReader;

public class lanzador {
    public static void ejecutarPing(String host) {
        String comando = "ping -c 4 " + host;
       try {
            Process proceso = Runtime.getRuntime().exec(comando);
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            int resultado = proceso.waitFor();
            if (resultado == 0) {
                System.out.println("El host " + host + " está activo.");
            } else {
                System.out.println("El host " + host + " no está activo.");
            }
        } catch (Exception e) {
            System.out.println("Error al ejecutar el comando ping: " + e.getMessage());
        }
    }
}

