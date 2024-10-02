package es.ies.puerto.ejercicio1;

import java.util.Random;

public class PokemonBattle implements Runnable {
    Pokemon myPokemon;
    Pokemon opponentPokemon;
    boolean loserDeclared = false;

    public PokemonBattle(Pokemon myPokemon, Pokemon opponentPokemon) {
        this.myPokemon = myPokemon;
        this.opponentPokemon = opponentPokemon;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (myPokemon.getHealth() > 0 && opponentPokemon.getHealth() > 0 && !loserDeclared) {

            int damage = random.nextInt(10) + 1;
            opponentPokemon.setHealth(opponentPokemon.getHealth() - damage);
            System.out.println(myPokemon.getName() + " causó " + damage + " de daño a " + opponentPokemon.getName() + "\n");
            System.out.println(myPokemon.getName() + ": " + myPokemon.getHealth() + " HP remaining\n");
            System.out.println(opponentPokemon.getName() + ": " + opponentPokemon.getHealth() + " HP remaining\n");
            

            if (myPokemon.getHealth() <= 0 && !loserDeclared) {
                loserDeclared = true;
                System.out.println(myPokemon.getName() + " ha perdido el combate!");
            }
            
            if (opponentPokemon.getHealth() <= 0 &&!loserDeclared) {
                loserDeclared = true;
                System.out.println(opponentPokemon.getName() + " ha perdido el combate!");
            }

            try {
                Thread.sleep(500); // Pausa entre pasos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Pokemon pikachu = new Pokemon("Pikachu", 50);
        Pokemon charmander = new Pokemon("Charmander", 50);
        
        Thread pikachuThread = new Thread(new PokemonBattle(pikachu, charmander));
        Thread charmanderThread = new Thread(new PokemonBattle(charmander, pikachu));

        pikachuThread.start();
        charmanderThread.start();
    }
    
}
