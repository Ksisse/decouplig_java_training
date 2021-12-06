package fr.lernejo.logger;

public class CompositeLogger implements Logger
{
    private final Logger l1;
    private final Logger l2;
    public CompositeLogger(Logger  l1 , Logger  l2 )
    {
        this.l1=l1;
        this.l2=l2;
    }
    @Override
    public void log(String message)
    {
        l1.log(message);
        l2.log(message);
    }
}