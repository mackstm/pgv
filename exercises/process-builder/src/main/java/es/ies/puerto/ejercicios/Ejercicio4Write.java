package es.ies.puerto.ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio4Write {
    public static void main(String[] args) {
        if (args.length != 1) {
            return;
        }

        String path = "src/main/resources/" + args[0];

        try (BufferedWriter br = new BufferedWriter(new FileWriter(path))) {
            br.write("Hello World");
        } catch(IOException e) {
            System.out.println("NOOOO" + e.getMessage());
        }
    }
}
