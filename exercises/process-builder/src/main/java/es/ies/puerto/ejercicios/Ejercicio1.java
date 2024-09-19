package es.ies.puerto.ejercicios;

import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        // Crear un nuevo proceso que ejecuta el comando 'ping'
        ProcessBuilder pb = new ProcessBuilder("ping", "-c", "3", "google.com");

        try {
            // Iniciar el proceso
            Process proceso = pb.start();
            
            // Esperar a que el proceso termine
            int exitCode = proceso.waitFor();
            System.out.println("Código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
