package Sharyn;

import Processing.InputProcessing;
import Processing.OutputProcessing;
import Store_Unknown.StoreUnknown;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;

public class Bot_Controller {

    private Bot_View view;
    private Bot sharyn;
    private Chat chatSession;
    private String answer;
    private String userInput;
    private InputProcessing inputProcess;
    private OutputProcessing outputProcess;
    private StoreUnknown store;
    

    public Bot_Controller(Bot_View view, Bot sharyn) {

        this.view = view;
        this.sharyn = sharyn;
        chatSession = new Chat(sharyn);
        inputProcess = new InputProcessing();
        outputProcess = new OutputProcessing();
        store = new StoreUnknown();
        
        view.getInput().addActionListener(new ControllerActionListener());

    }

    //takes user input and shows it on screen
    public String takeInput() {

        userInput = view.getInput().getText();
        Format("User-> ", userInput);
        view.getInput().setText("");//empties input

        return userInput;
    }

    //takes user input and shows it on screen
    public String checkforstore(String answer, String userInput) {

        if (answer.equals("I have no answer for that.")) {

            store.StoreWord(userInput);

        }

        return answer;
    }

    //format text to not get out of bounds and display it on the gui
    public void Format(String user, String text) {

        int toIndex = 64-user.length(), fromIndex = 0;

        while (toIndex < text.length()) {
            toIndex = text.substring(0, toIndex).lastIndexOf(" ");
            if (fromIndex == 0) {
                view.getScreen().append(user + text.substring(fromIndex, toIndex) + "\n");
            } else {
                view.getScreen().append(text.substring(fromIndex + 1, toIndex) + "\n");
            }
            fromIndex = toIndex;
            toIndex += 64;
        }
        if (fromIndex == 0) {
            view.getScreen().append(user + text.substring(fromIndex) + "\n");
        } else {
            view.getScreen().append(text.substring(fromIndex + 1) + "\n");
        }

    }

    //delay bots response
    public void delayedAnswer() {

        Thread t1;
        t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                Format("Sharyn-> ", answer);

            } catch (InterruptedException ex) {
                Logger.getLogger(Bot_View.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        });
        t1.start();
        t1.setPriority(Thread.MIN_PRIORITY);

    }

    private class ControllerActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            userInput = takeInput();
            userInput = inputProcess.process(userInput);
            answer = chatSession.multisentenceRespond(userInput);
            checkforstore(answer, userInput);
            answer = outputProcess.checkNoAnswer(answer);
            answer = outputProcess.checkUnknown(answer);     
            System.out.println(answer);
            delayedAnswer();

        }
    }

}
