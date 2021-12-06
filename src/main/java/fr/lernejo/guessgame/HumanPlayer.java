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
            logger.log("What's your next guess? ");
            userInput = scanner.nextLine();
            try {
                guess = Long.parseLong(userInput);
                retry = false;
            } catch (Exception e) {
                logger.log("Please enter a number.");
                retry = true;
            }
        } while (retry);

        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (!lowerOrGreater) logger.log("The number is lower.");
        else logger.log("The number is higher.");
    }
}