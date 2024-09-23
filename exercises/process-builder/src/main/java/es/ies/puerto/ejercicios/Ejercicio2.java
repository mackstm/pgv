package es.ies.puerto.ejercicios;

import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {
        ProcessBuilder pingPb = new ProcessBuilder("ping", "-c", "3", "google.com");
        ProcessBuilder lsPb = new ProcessBuilder("ls", "-la");
        ProcessBuilder echoPb = new ProcessBuilder("echo", "mecagoencima");

        try {
            Process pingProcess = pingPb.start();
            int pingExitCode = pingProcess.waitFor();
            System.out.println("Código de salida: " + pingExitCode);

            Process lsProcess = lsPb.start();
            int lsExitCode = lsProcess.waitFor();
            System.out.println("Código de salida: " + lsExitCode);

            Process echoProcess = echoPb.start();
            int echoExitCode = echoProcess.waitFor();
            System.out.println("Código de salida: " + echoExitCode);
        } catch (IOException | InterruptedException e) {
            System.err.println("Error executing command: " + e.getMessage());
        }
        // TODO Auto-generated catch block
        
    }
}
