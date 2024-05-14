import Controller.Controller;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Application {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Controller controller = new Controller(args);
    }
}
