public class Main {

    public static void main(String[] args) {
        Options.parseCommandLine(args);

        Timer timer_dico = new Timer("Construction du dictionnaire");
        Dictionary dico = new Dictionary(Options.pathToDictionary);
        timer_dico.print_time_past();

        Timer timer_speller = new Timer("Vérification de l'ortographe");

        SpellChecker spellchecker = new SpellChecker(Options.pathToFile, Options.word, dico);
        for (String word : spellchecker.getWords()) {
            spellchecker.spell(word);
        }
        timer_speller.print_time_past();
    }

    private static class Timer {
        long startTime = 0;
        String name = "";

        public Timer(String name) {
            startTime = System.currentTimeMillis();
            this.name = name;
        }

        public long time_past() {
            return System.currentTimeMillis() - startTime;
        }

        public void print_time_past() {
            String message = String.format("Timer %s : %f sec. past", name, ((double) time_past()) / 1000);
            System.out.println(message);
        }

    }
}
