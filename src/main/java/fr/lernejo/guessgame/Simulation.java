package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;
    private long max_try;

    public Simulation(Player player) {
        this.player = player;
        this.numberToGuess = 0;
        this.max_try = 0;
    }

    public void initialize(long numberToGuess, long maxTry) {
        this.numberToGuess = numberToGuess;
        this.max_try = maxTry;
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
        int tryNumber = 0;

        long gameBegin = System.currentTimeMillis();
        do {
            tryNumber++;
            continueGame = nextRound();
        } while (!continueGame && tryNumber < max_try);
        long gameEnd = System.currentTimeMillis();

        long timeInGame = gameEnd - gameBegin;

        if (continueGame) {
            logger.log("Bravo le nombre était " + numberToGuess);
            logger.log("Cela à prit " + tryNumber + " essais");
        } else logger.log("FAUX le nombre était " + numberToGuess + ", GAME OVER.");

        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
        Date resultTime = new Date(timeInGame);
        logger.log("Time in-game: " + sdf.format(resultTime));
    }
}