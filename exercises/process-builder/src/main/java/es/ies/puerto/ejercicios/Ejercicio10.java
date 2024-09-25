package es.ies.puerto.ejercicios;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Ejercicio10 {
    public static void main(String[] args) {
        ProcessBuilder pbLs = new ProcessBuilder("ls", "-l");
        ProcessBuilder pbGrep = new ProcessBuilder("grep", "README");

        try {
            Process lsProcess = pbLs.start();
            
            InputStream lsIn = lsProcess.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(lsIn));

            String lsOutput = "";

            while (br.readLine()!= null) {
                lsOutput += br.readLine() + "\n";
            }
            
            int lsExit = lsProcess.waitFor();

            Process grepProcess = pbGrep.start();

            OutputStream grepOut = grepProcess.getOutputStream();

            int outputExit = grepProcess.waitFor();
        
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
