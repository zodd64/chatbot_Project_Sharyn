package Store_Unknown;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StoreUnknown {

    private String filePath;

    public StoreUnknown() { 

        filePath = new File("").getAbsolutePath();

    }

    public void StoreWord(String question) {

        try {
            FileWriter myWriter = new FileWriter(filePath + "/src/Store_Unknown/Log.txt", true);
            myWriter.write(question);
            myWriter.write("\n");
            myWriter.close();
            System.out.println("New unknown question logged.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
