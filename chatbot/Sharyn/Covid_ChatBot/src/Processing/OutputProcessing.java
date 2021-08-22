package Processing;

import java.util.ArrayList;
import java.util.Random;

public class OutputProcessing implements OutputProcessInterface {

    private ArrayList<String> confusedRespones;

    public OutputProcessing() {
        
        confusedRespones = new ArrayList<String>(3);
        confusedRespones.add("Mήπως γίνεται να αναδιατυπώσεις;");
        confusedRespones.add("Δυστυχώς δεν καταλαβαίνω τι εννοείς;");
        confusedRespones.add("Είναι εύκολο να επαναδιατυπώσεις;");

    }

    //if bot doesnt have answer change standard response to greek
    @Override
    public String checkNoAnswer(String answer) {

        Random r = new Random();
        int n = r.nextInt(3); //generate random response

        if (answer.equals("I have no answer for that.")) {

            answer = confusedRespones.get(n); //get random response from array of responses

        }

        return answer;

    }

    //if bots answer contains the word unkown convert to χρήστη
    @Override
    public String checkUnknown(String answer) {

        if (answer.contains("unknown")) {
            answer = answer.replaceAll("\\bunknown\\b", "χρήστη");

        }

        return answer;

    }

}
