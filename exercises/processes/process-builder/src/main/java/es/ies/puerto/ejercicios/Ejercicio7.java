package es.ies.puerto.ejercicios;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejercicio7 {
    public static void main(String[] args) {
        ProcessBuilder pbProducer = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), "es.ies.puerto.ejercicios.Producer");
        ProcessBuilder pbConsumer = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), "es.ies.puerto.ejercicios.Consumer");

        try {
            Process producerProcess = pbProducer.start();
            Process consumerProcess = pbConsumer.start();

            InputStream producerIn = producerProcess.getInputStream();
            OutputStream consumerOut = consumerProcess.getOutputStream();
            
            byte[] buffer = new byte[1024];
            int readBytes;

            while ((readBytes = producerIn.read(buffer)) != 1) {
                consumerOut.write(buffer, 0, readBytes);
                consumerOut.flush();
            }

            producerIn.close();
            consumerOut.close();

            int producerExitCode = consumerProcess.waitFor();
            int consumerExitCode = producerProcess.waitFor();

            System.out.println(producerExitCode);
            System.out.println(consumerExitCode);
        } catch (IOException | InterruptedException ex) {
        }
    }
}
