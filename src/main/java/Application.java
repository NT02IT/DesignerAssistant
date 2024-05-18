import Controller.Controller;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Application {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

//        String apiKey = System.getenv("GEMINI_API");
//        if (apiKey != null) {
//            System.out.println("GEMINI_API: " + apiKey);
//        } else {
//            System.out.println("API Key is not set.");
//        }

        Controller controller = new Controller(args);
    }
}
