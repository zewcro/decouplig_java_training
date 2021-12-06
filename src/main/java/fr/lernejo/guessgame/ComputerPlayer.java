package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class ComputerPlayer implements Player {
    private long lastGuess = 0;
    private long minLimit = 0;
    private long maxLimit = 100;

    @Override
    public long askNextGuess() {
        SecureRandom random = new SecureRandom();
        long guess = random.nextLong(minLimit, maxLimit);

        lastGuess = guess;
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (!lowerOrGreater) {
            maxLimit = lastGuess;
        } else {
            minLimit = lastGuess;
        }
    }
}