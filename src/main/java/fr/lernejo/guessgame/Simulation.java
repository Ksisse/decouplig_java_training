package fr.lernejo.guessgame;


import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player= player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess=numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {// test part pour savoir si le nbre du joueur est + grand ou + petit ou égal
        Long number = player.askNextGuess();
        if(number.equals(numberToGuess))
        {
            logger.log("Congrats u win the Captain Age : "+numberToGuess);
            return true;
        }
        else
        {
            player.respond(number <= numberToGuess);
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long MAXI) {
        logger.log("The Party can start !");
        boolean test=nextRound();
        int i=0;
        long Start=System.currentTimeMillis();
        if (!test && i < MAXI) {
            do {
                test = nextRound();
                i++;
            } while (!test && i < MAXI);
        }
        long End = System.currentTimeMillis();
        long TimeTotal = End-Start;
        Timestamp timestamp=new Timestamp(TimeTotal);
        logger.log("Temps : "+new SimpleDateFormat("mm:ss.SSS").format(timestamp));


    }

}