package es.ies.puerto.ejercicio06;

import java.util.Random;

public class TardisSimulator implements Runnable{
    private String periodName;
    private int progress = 0;
    private static final int GOAL = 100;
    private static boolean winnerDeclared = false;

    public TardisSimulator(String name) {
        this.periodName = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (progress < GOAL && !winnerDeclared) {
            int time = random.nextInt(10) + 1; // Avance aleatorio de 1 a 10
            progress += time;
            System.out.println(periodName + " ha avanzado " + time + " segundos. Progreso total: " + progress + " segundos.");
            
            if (progress >= GOAL && !winnerDeclared) {
                winnerDeclared = true;
                System.out.println("hemos llegado al" + periodName + "!");
            }

            try {
                Thread.sleep(500); // Pausa entre pasos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread past = new Thread(new TardisSimulator("Pasado"));
        Thread future = new Thread(new TardisSimulator("Futuro"));

        past.start();
        future.start();
    }
}
