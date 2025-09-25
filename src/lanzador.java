import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Lanzador {
    public static void ejecutarPing(String host) {
        ArrayList<String> comando = new ArrayList<>();

     
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            comando.add("ping");
            comando.add("-n");
            comando.add("4");
            comando.add(host);
        } else {
            comando.add("ping");
            comando.add("-c");
            comando.add("4");
            comando.add(host);
        }

        try {
            ProcessBuilder pb = new ProcessBuilder(comando);
            pb.redirectErrorStream(true); 
            Process proceso = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            int codigo = proceso.waitFor();
            System.out.println("Código de salida: " + codigo);

            if (codigo == 0) {
                System.out.println("El host " + host + " responde al ping.");
            } else {
                System.out.println("No se pudo hacer ping a " + host);
            }

        } catch (Exception e) {
            System.out.println("Error al ejecutar el ping: " + e.getMessage());
        }
    }
}
