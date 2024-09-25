package es.ies.puerto.ejercicios;

import java.io.IOException;

public class Ejercicio8 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ping", "-c", "3", "google.com");
        long startTime = System.currentTimeMillis();
        try {
            Process process = pb.start();
            int exitCode = process.waitFor();
            long endTime = System.currentTimeMillis();
            int totalTime = (int) (endTime - startTime);
            System.out.println(totalTime + " ms");
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }

    }
}
