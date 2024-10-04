package es.ies.puerto.ejercicio2;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class HorrocruxCaza implements Runnable {
    private String name;
    private static final int GOAL = 2000;
    private static boolean winnerDeclared = false;

    public HorrocruxCaza(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        long start = System.currentTimeMillis();
        long timePassed = 0;
        while (timePassed < GOAL && !winnerDeclared) {
            int time = random.nextInt(1000) + 1; // Avance aleatorio de 1 a 10
            long end = System.currentTimeMillis();
                timePassed = (end - start);
                System.out.println(name + " lleva " + timePassed + " milisegundos.");

                if (timePassed >= GOAL && !winnerDeclared) {
                    winnerDeclared = true;
                    System.out.println(name + " ha ganado con " + timePassed + " milisegundos!");
                }
            try {
                Thread.sleep(time);
                
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread harry = new Thread(new HorrocruxCaza("Harry"));
        Thread ron = new Thread(new HorrocruxCaza("Ron"));
        Thread hermione = new Thread(new HorrocruxCaza("Hermione"));

        harry.start();
        ron.start();
        hermione.start();
    }
}
