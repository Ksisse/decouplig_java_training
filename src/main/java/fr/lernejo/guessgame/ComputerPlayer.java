package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{
    long min=0;
    long max=100;
    long mid;
    Logger l = LoggerFactory.getLogger("player");
    @Override
    public long askNextGuess()
    {
        mid = (max + min) / 2;
        return mid;
    }
    @Override
    public void respond(boolean lowerOrGreater)
    {
        if (lowerOrGreater) {
            l.log("Lower");
            max=(max + min) / 2;
        } else {
            l.log("Greater");
            min=(max + min) / 2;
        }

    }
}