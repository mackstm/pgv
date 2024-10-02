package es.ies.puerto.ejercicios;
import java.io.IOException;

public class Ejercicio9 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ping", "google.com");
        
        try {
            Process process = pb.start();
            long startTime = System.currentTimeMillis();
            boolean isRunning = true;

            while (isRunning) {
                long currentTime = System.currentTimeMillis();

                if ((currentTime - startTime) >= 10000) {
                    process.destroy();
                    isRunning = false;
                }
            }
            int exitCode = process.waitFor();
            long endTime = System.currentTimeMillis();
            int totalTime = (int) (endTime - startTime);

           
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
