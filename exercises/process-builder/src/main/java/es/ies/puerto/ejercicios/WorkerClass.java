package es.ies.puerto.ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WorkerClass {
    public static void main(String[] args) {
        if (args.length != 1) {
            return;
        }

        String instance = args[0];
        String line = "Worker " + instance + " running...";
        String path = "src/main/resources/ej6output.txt";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path, true))) {
            br.write(line);
            br.newLine();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
