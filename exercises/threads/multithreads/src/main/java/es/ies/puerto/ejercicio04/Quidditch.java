package es.ies.puerto.ejercicio04;

import java.util.Random;

public class Quidditch implements Runnable{
    private String name;
    private int points = 0;
    private int snitchProgress = 0;
    private static final int GOAL = 100;
    private static boolean winnerDeclared = false;
    private boolean isFinder;

    public Quidditch(String name, boolean isFinder) {
        this.name = name;
        this.isFinder = isFinder;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (points < GOAL && snitchProgress < GOAL && !winnerDeclared) {
            if (!isFinder) {
                int pointAdd = random.nextInt(10) + 1; // Avance aleatorio de 1 a 10
                points =+ pointAdd;
                System.out.println(name + " lleva " + points + " puntos.");
            }
            
            int progressAdd = random.nextInt(10) + 1;
            snitchProgress += progressAdd;

            System.out.println("Búsqueda de Snitch dorada de " + name + ": " + snitchProgress + "%");
            
            if (points >= GOAL || snitchProgress >= GOAL && !winnerDeclared) {
                winnerDeclared = true;
                System.out.println(name + " ha ganado!");
            }
            try {
                Thread.sleep(500);
                
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread hunter1 = new Thread(new Quidditch("Hunter 1", false));
        Thread hunter2 = new Thread(new Quidditch("Hunter 2", false));
        Thread finder = new Thread(new Quidditch("The Finder", true));

        hunter1.start();
        hunter2.start();
        finder.start();
    }
}
