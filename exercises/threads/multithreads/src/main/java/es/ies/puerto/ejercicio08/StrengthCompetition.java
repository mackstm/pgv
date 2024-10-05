package es.ies.puerto.ejercicio08;

import java.util.Random;

public class StrengthCompetition implements Runnable {
    private String heroName;
    private int progress = 0;
    private static final int GOAL = 1000;
    private static boolean winnerDeclared = false;

    public StrengthCompetition(String name) {
        this.heroName = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (progress < GOAL && !winnerDeclared) {
            int weightAdd = random.nextInt(100) + 1; // Avance aleatorio de 1 a 10
            progress += weightAdd;
            System.out.println(heroName + " ha levantado " + weightAdd + " kilos más. Progreso total: " + progress + " kilos.");
            
            if (progress >= GOAL && !winnerDeclared) {
                winnerDeclared = true;
                System.out.println(heroName + " ha ganado!");
            }

            try {
                Thread.sleep(500); // Pausa entre pasos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread hulk = new Thread(new StrengthCompetition("Hulk"));
        Thread thor = new Thread(new StrengthCompetition("Thor"));

        hulk.start();
        thor.start();
    }
}
