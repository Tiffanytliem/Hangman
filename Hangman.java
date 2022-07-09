import java.util.Scanner;

public class Hangman {

    public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra" };

    public static String[] gallows = { "+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + // if you were wondering, the only way to print '\' is with a trailing escape
                                  // character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n" };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = words[randomNumber()];

        char[] placeHolder = new char[word.length()];

        for (int i = 0; i < placeHolder.length; i++) {
            placeHolder[i] = '_';
        }

        char[] guessed = new char[6];

        // System.out.println("\n\nMisses:\t" +

        int misses = 0;

        while (misses < 6) {
            System.out.println(gallows[misses]);
            System.out.print("Word:\t");
            printPlaceHolder(placeHolder);
            printMisses(guessed);
            System.out.print("\n\nGuess: ");
            char guess = scan.next().charAt(0);
            if (checkGuess(guess, word)) {
                updatePlaceHolder(placeHolder, guess, word);
            } else {
                misses++;
                guessed[misses - 1] = guess;
            }
            String plHolder = new String(placeHolder);

            if (plHolder.equals(word)) {
                System.out.println("/nGOOD WORK!");
                System.exit(0);
            }
        }

        if (misses == 6) {
            System.out.println(gallows[6]);
            System.out.println("\n\nRIP!");
            System.out.println("\n\nThe word was: " + word);
        }
        ;

        scan.close();

    }
    // Create a function to generate random number

    public static int randomNumber() {
        double number = (Math.random() * (words.length));
        return (int) number;
    }

    // Create a function to print/update the word;

    public static void printWord(char[] word) {
        for (int i = 0; i < word.length; i++) {
            System.out.print(word[i] + " ");
        }
    }

    // Create a function to print placeHolder;

    public static void printPlaceHolder(char[] placeHolder) {
        for (int i = 0; i < placeHolder.length; i++) {
            System.out.print(placeHolder[i] + " ");
        }
    }

    // Create a function to print misses:
    public static void printMisses(char[] array) {
        System.out.print("\n\nMisses: ");
        String string = new String(array);
        System.out.println(string);
    }

    // Create a function to update placeHolder:
    public static void updatePlaceHolder(char[] placeHolder, char guess, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (guess == word.charAt(i)) {
                placeHolder[i] = guess;
            }
        }
    }

    // Create a function to check if guess is correct:
    public static boolean checkGuess(char guess, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (guess == word.charAt(i)) {
                return true;
            }
        }
        return false;
    }

}
