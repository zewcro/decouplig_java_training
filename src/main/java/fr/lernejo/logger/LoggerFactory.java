public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new ContextualLogger(name, new FileLogger("./logs.txt"));
        return new ContextualLogger(
            name,
            new CompositeLogger(
                new ConsoleLogger(),
                new FileLogger("./logs.txt")
            )
        );
    }
}