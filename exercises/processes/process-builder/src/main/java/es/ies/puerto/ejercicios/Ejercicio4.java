package es.ies.puerto.ejercicios;

import java.io.IOException;


public class Ejercicio4 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), 
        "es.ies.puerto.ejercicios.Ejercicio4Write", "ej4output.txt");

        Process process;
        try {
            process = pb.start();
            int exitCode = process.waitFor();
            System.out.println("Código de salida: " + exitCode);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Process error" + ex.getMessage());
        }

    }
}
