package es.ies.puerto.ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Producer {
    public static void main(String[] args) {
        String path = "src/main/resources/ej7output.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < 5; i++) {
                bw.write("Produced: " + i);
                bw.newLine(); // Simulating production delay
            }
            bw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
