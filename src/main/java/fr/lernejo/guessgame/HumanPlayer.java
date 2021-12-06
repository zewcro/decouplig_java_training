package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        long guess = 0;
        Scanner scanner = new Scanner(System.in);
        String userInput;
        boolean retry;

        do {
            logger.log("Quelle est ta prochaine hypothèse ?");
            userInput = scanner.nextLine();
            try {
                guess = Long.parseLong(userInput);
                retry = false;
            } catch (Exception e) {
                logger.log("Mettre un nombre ");
                retry = true;
            }
        } while (retry);

        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (!lowerOrGreater) logger.log("C'est moins ");
        else logger.log("C'est plus ");
    }
}