package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        Player player = new HumanPlayer();
        Simulation game = new Simulation(player);

        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100);

        game.initialize(randomNumber);
        game.loopUntilPlayerSucceed();
    }
}