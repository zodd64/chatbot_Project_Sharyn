package covid_chatbot;

import Sharyn.Bot_Controller;
import Sharyn.Bot_View;
import java.io.File;
import org.alicebot.ab.Bot;


public class Main {

    private Bot_Controller controller;
    private Bot_View view;
    private Bot sharyn;

    public Main() {

        String filePath = new File("").getAbsolutePath();
        view = new Bot_View();
        sharyn = new Bot("Sharyn", filePath + "/src/resources");
        Bot_Controller bot_Controller = new Bot_Controller(view, sharyn);
        
    }

}
