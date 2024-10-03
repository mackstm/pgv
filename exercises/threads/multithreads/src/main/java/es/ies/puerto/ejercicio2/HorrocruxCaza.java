package es.ies.puerto.ejercicio2;

import java.util.Random;

public class HorrocruxCaza implements Runnable {
    private String name;
    private static boolean winnerDeclared = false;

    public HorrocruxCaza(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        int huntTime = random.nextInt(1000) + 1;

            try {
                Thread.sleep(huntTime); // Pausa entre pasos
                System.out.println(name + " ha ganado la caza");
            } catch (InterruptedException e) {
                e.printStackTrace();
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
