package es.ies.puerto.ejercicio07;

import java.util.Random;

public class CitySaving implements Runnable{
    private String heroName;
    private int progress = 0;
    private static final int GOAL = 100;
    private static boolean winnerDeclared = false;

    public CitySaving(String name) {
        this.heroName = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (progress < GOAL && !winnerDeclared) {
            int savePercent = random.nextInt(10) + 1; // Avance aleatorio de 1 a 10
            progress += savePercent;
            System.out.println(heroName + " ha salvado el " + savePercent + "% de la ciudad. Progreso total: " + progress + "%.");
            
            if (progress >= GOAL && !winnerDeclared) {
                winnerDeclared = true;
                System.out.println(heroName + " ha salvado a su ciudad!");
            }

            try {
                Thread.sleep(500); // Pausa entre pasos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread superman = new Thread(new CitySaving("Superman"));
        Thread batman = new Thread(new CitySaving("Batman"));

        superman.start();
        batman.start();
    }
}
