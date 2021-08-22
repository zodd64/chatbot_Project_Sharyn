package Processing;

public interface InputProcessInterface {

    //removes hyphens from the users input
    String cleanHyphen(String str);

    //removes punctuationusers input
    String cleanString(String str);

    //combines the processes and put input in lowercase
    String process(String userinput);
    
}
