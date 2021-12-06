package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
        this.numberToGuess = 0;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long userGuess = player.askNextGuess();

        if (userGuess == numberToGuess) return true;
        else {
            player.respond(userGuess < numberToGuess);
        }
        return false;
    }

    public void loopUntilPlayerSucceed() {
        boolean continueGame;

        do {
            continueGame = nextRound();
        } while (!continueGame);

        logger.log("Well done! The number was " + numberToGuess);
    }
}