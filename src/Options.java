import java.util.Arrays;

public class Options {

    public static String pathToDictionary= "resources/dico.txt";
    public static String pathToFile = "resources/fautes.txt";

    public static void parseCommandLine(String[] args) {
        pathToDictionary= "resources/dico.txt";
        pathToFile = "resources/fautes.txt";

        if (args.length == 0) {
            return;
        }

        int index = 0;
        String[] helpStrs = {"-h", "--help"};
        if (Arrays.asList(helpStrs).contains(args[index])) {
            usage();
            System.exit(0);
        }

        String[] dictStrs = {"-d", "--dict", "--dico"};
        if (Arrays.asList(dictStrs).contains(args[index])) {
            index++;
            try {
                pathToDictionary = args[index++];
            } catch (Exception e) {
                System.out.println("I need the name of the file containing the dictionary");
                System.exit(1);
            }

        }

        try {
            pathToFile = args[index];
        } catch (Exception e) {
            System.out.println("I need the name of the file containing the dictionary");
            System.exit(1);
        }

    }

    private static void usage() {
        System.out.println("Usage : spellcheck [-d dictionary] [file]");
    }

    public static void print(){
        System.out.println(String.format("Dictionnaire : %s", Options.pathToDictionary));
        System.out.println(String.format("Fichier : %s",Options.pathToFile));
    }

}
