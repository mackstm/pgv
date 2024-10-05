package es.ies.puerto.ejercicio09;

import java.util.Random;

public class FalconSimulator implements Runnable {
    private String name;
    private int progress = 0;
    private static final int GOAL = 100;
    private static boolean milleniumDestroyed = false;

    public FalconSimulator(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (progress < GOAL && !milleniumDestroyed) {
            int systemDamage = random.nextInt(10) + 1; // Avance aleatorio de 1 a 10
            progress += systemDamage;
            System.out.println(name + " ha recibido " + systemDamage + "% de daño a su sistema. Progreso total hacia fallo de sistema: " + progress + "%.");
            
            if (progress >= GOAL && !milleniumDestroyed) {
                milleniumDestroyed = true;
                System.out.println(name + " ha fallado!");
            }

            try {
                Thread.sleep(500); // Pausa entre pasos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread hansolo = new Thread(new FalconSimulator("Han Solo"));
        Thread chewbacca = new Thread(new FalconSimulator("Chewbacca"));

        hansolo.start();
        chewbacca.start();
    }
}
