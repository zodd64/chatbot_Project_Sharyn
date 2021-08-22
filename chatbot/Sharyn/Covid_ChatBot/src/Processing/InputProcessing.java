package Processing;

public class InputProcessing implements InputProcessInterface {

    //removes punctuationusers input
    @Override
    public String cleanString(String str) {

        String result = str.replaceAll("[?!:.;,]", "");
        return result;
    }

    //removes hyphens from the users input
    @Override
    public String cleanHyphen(String str) {
        if (str.contains("ά")) {
            str = str.replace('ά', 'α');
        }
        if (str.contains("έ")) {
            str = str.replace('έ', 'ε');
        }
        if (str.contains("ί")) {
            str = str.replace('ί', 'ι');
        }
        if (str.contains("ή")) {
            str = str.replace('ή', 'η');
        }
        if (str.contains("ύ")) {
            str = str.replace('ύ', 'υ');
        }
        if (str.contains("ό")) {
            str = str.replace('ό', 'ο');
        }
        if (str.contains("ώ")) {
            str = str.replace('ώ', 'ω');
        }
        return str;
    }

    //combines the processes and put input in lowercase
    @Override
    public String process(String userinput) {

        userinput = cleanString(userinput);
        userinput = userinput.toLowerCase();
        userinput = cleanHyphen(userinput);

        return userinput;

    }

}
