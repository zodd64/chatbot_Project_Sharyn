package Processing;

public interface OutputProcessInterface {

    //if bot doesnt have answer change standard response to greek
    String checkNoAnswer(String answer);

    //if bots answer contains the word unkown convert to χρήστη
    String checkUnknown(String answer);
    
}
