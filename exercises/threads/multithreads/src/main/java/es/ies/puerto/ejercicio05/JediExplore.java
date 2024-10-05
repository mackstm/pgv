package es.ies.puerto.ejercicio05;

import java.util.Random;

public class JediExplore implements Runnable{
    private String name;
    private int progress = 0;
    private static final int GOAL = 100;
    private static boolean winnerDeclared = false;

    public JediExplore(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (progress < GOAL && !winnerDeclared) {
            int clues = random.nextInt(10) + 1; // Avance aleatorio de 1 a 10
            progress += clues;
            System.out.println(name + " encontro " + clues + " pistas. Progreso total: " + progress + " pistas.");
            
            if (progress >= GOAL && !winnerDeclared) {
                winnerDeclared = true;
                System.out.println(name + " ha encontrado todas las pistas del lado oscuro!");
            }

            try {
                Thread.sleep(500); // Pausa entre pasos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread obiwan = new Thread(new JediExplore("Obi Wan"));
        Thread anakin = new Thread(new JediExplore("Anakin"));

        obiwan.start();
        anakin.start();
    }
}
