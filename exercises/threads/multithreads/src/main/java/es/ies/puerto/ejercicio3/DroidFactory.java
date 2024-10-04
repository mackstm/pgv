package es.ies.puerto.ejercicio3;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class DroidFactory implements Runnable {
    private int parts = 0;
    private static final int TOTAL_PARTS = 100;
    private static boolean assemblyComplete = false;

    public DroidFactory() {
        
    }

    @Override
    public void run() {
        Random random = new Random();
        while (parts < TOTAL_PARTS && !assemblyComplete) {
            
            
            int partAdd = random.nextInt(10) + 1;

                System.out.println("Droide ensamblado %:" + parts + "%");
                parts += partAdd;
            
            if (parts >= TOTAL_PARTS && !assemblyComplete) {
                synchronized (this) {
                    assemblyComplete = true;
                }
                
            }
            
            

            try {
                Thread.sleep(500); // Pausa entre pasos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread droidMaker = new Thread(new DroidFactory());
        Thread droidActivator = new Thread(new DroidFactory());

        droidMaker.start();
        droidActivator.start();

        try {
            droidMaker.join();
            droidActivator.join();
        } catch (InterruptedException ex) {
        }
        System.out.println("Ensamblaje completado!");
    }
}
