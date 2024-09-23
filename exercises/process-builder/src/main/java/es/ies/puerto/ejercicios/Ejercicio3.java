package es.ies.puerto.ejercicios;

import java.io.File;
import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ls", "-la");
        File output = new File("src/main/resources/lsOutput.txt");
        pb.redirectOutput(output);
        try {
            // Iniciar el proceso
            Process proceso = pb.start();
            
            // Esperar a que el proceso termine
            int exitCode = proceso.waitFor();
            System.out.println("Código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            System.err.println("Error executing command: " + e.getMessage());
        }
    }
}
