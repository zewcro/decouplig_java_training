package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("computer");
    private long lastGuess = 0;
    private long minLimit = 0;
    private long maxLimit = 100;
    @Override
    public long askNextGuess() {
        SecureRandom random = new SecureRandom();
        long guess = random.nextLong(minLimit, maxLimit);

        logger.log("Trouvé " + guess);

        lastGuess = guess;
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (!lowerOrGreater) {
            logger.log("C'est moins ");
            maxLimit = lastGuess;
        } else {
            logger.log("C'est plus ");
            minLimit = lastGuess;
        }
    }
}