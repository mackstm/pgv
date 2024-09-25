package es.ies.puerto.ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Consumer {
    public static void main(String[] args) {
        String path = "src/main/resources/ej7output.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Consumed: " + line);
            }
            br.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
