package es.ies.puerto.ejercicios;

import java.io.IOException;

public class Ejercicio6 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
                try {
                    ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), 
                    "es.ies.puerto.ejercicios.WorkerClass", String.valueOf(i));
                    Process process = pb.start();
                    int exitCode = process.waitFor();
                    System.out.println(exitCode);
                } catch (IOException | InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            
        }
    }
}
