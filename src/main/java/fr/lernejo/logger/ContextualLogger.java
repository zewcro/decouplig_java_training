package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {
    private final Logger delegateLogger;
    private final String callerClass;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public ContextualLogger(String name, Logger logger) {
        this.delegateLogger = logger;
        this.callerClass = name;
    }

    @Override
    public void log(String message) {
        delegateLogger.log(LocalDateTime.now().format(formatter) + " " + callerClass + " " + message);
    }
}