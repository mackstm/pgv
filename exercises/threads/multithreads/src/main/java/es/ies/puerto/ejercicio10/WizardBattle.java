package es.ies.puerto.ejercicio10;

import java.util.Random;


public class WizardBattle implements Runnable {
    private String myWizard;
    private String oppWizard;
    private int oppHealth = 100;
    private static boolean winnerDeclared = false;

    public WizardBattle(String myWizard, String oppWizard) {
        this.myWizard = myWizard;
        this.oppWizard = oppWizard;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (oppHealth > 0 && !winnerDeclared) {

            int damage = random.nextInt(10) + 1;
            int spellTime = random.nextInt(1000) + 1;
            oppHealth -= damage;
            System.out.println(myWizard + " causó " + damage + " de daño a " + oppWizard + ". Vida enemiga restante: " + oppHealth + ".");
            

            if (oppHealth <= 0 && !winnerDeclared) {
                winnerDeclared = true;
                System.out.println(myWizard + " ha ganado el combate!");
            }

            try {
                Thread.sleep(spellTime); // Pausa entre pasos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        
        Thread gandalf = new Thread(new WizardBattle("Gandalf", "Saruman"));
        Thread saruman = new Thread(new WizardBattle("Saruman", "Gandalf"));

        gandalf.start();
        saruman.start();
    }
}
