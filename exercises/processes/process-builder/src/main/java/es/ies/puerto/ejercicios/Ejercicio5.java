package es.ies.puerto.ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio5 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("cat", "noexisto.txt");

        pb.redirectErrorStream(true);
        Process proceso = pb.start();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        int errCode = proceso.waitFor();

        System.out.println("errCode: " + errCode);
    }
}
