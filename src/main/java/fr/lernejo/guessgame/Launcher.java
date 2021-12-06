package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args)
    {
        if(args.length==1 && args[0].equals("-interactive"))
        {
            long max = Long.MAX_VALUE;
            Player player = new HumanPlayer();
            Simulation s = new Simulation(player);
            SecureRandom random = new SecureRandom();
            long Number = random.nextInt(100);
            s.initialize(Number);
            s.loopUntilPlayerSucceed(max);
        }
        else if (args.length==2 && args[0].equals("-auto") && args[1].matches("[0-9]+"))
        {
            Player player = new ComputerPlayer();
            Simulation s1 = new Simulation(player);
            SecureRandom random = new SecureRandom();
            long number=Long.parseLong(args[1]);
            s1.initialize(number);
            s1.loopUntilPlayerSucceed(1000);
        }
        else
        {
            Logger logger = LoggerFactory.getLogger("launcher");
            logger.log("Error , please use the rights arguments ..");
        }

    }
}