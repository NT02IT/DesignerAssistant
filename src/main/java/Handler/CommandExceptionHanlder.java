package Handler;

import org.apache.logging.log4j.message.Message;

public class CommandExceptionHanlder extends RuntimeException{
    public CommandExceptionHanlder(String message) {
        super(message);
    }
}
