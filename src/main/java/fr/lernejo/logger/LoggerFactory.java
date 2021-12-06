package fr.lernejo.logger;
import java.util.function.Predicate;

public class LoggerFactory{
    Logger logger = LoggerFactory.getLogger("launcher");

    public static Logger getLogger(String name)
    {
        Logger filelogger = new FileLogger("./logs.txt");
        Predicate<String> condition = message -> message.contains("simulation");
        return new CompositeLogger(new ContextualLogger(name,new ConsoleLogger()), new ContextualLogger(name,new FilteredLogger(filelogger,condition)));
    }
}