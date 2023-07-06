import java.util.*;

public class HangmanGame {
    private static final int MAX_HP = 10; // Maximum HP for both player and executioner

    // Arrays of words for each level
    private static final String[] LEVEL_1_WORDS = { "bear", "cat", "dog", "fish", "frog" };
    private static final String[] LEVEL_2_WORDS = { "apple", "banana", "grape", "lemon", "melon" };
    private static final String[] LEVEL_3_WORDS = { "cheese", "dragon", "flower", "garden", "monkey" };
    private static final String[] LEVEL_4_WORDS = { "elephant", "kangaroo", "penguin", "turtle", "zebra" };
    private static final String[] LEVEL_5_WORDS = { "champion", "elephant", "hospital", "jupiter", "rainbow" };

    private static final int[] LEVEL_DAMAGE = { 2, 4, 6, 8, 10 }; // Damage values for each level

    public static void main(String[] args) {
        System.out.println("Welcome to Hangman Game!");
        System.out.println("In this game, you'll guess a word to defeat the executioner.");
        System.out.println("Both you and the executioner start with " + MAX_HP + " HP.");

        Scanner scanner = new Scanner(System.in);
        int playerHP = MAX_HP; // Initialize player HP
        int executionerHP = MAX_HP; // Initialize executioner HP

        while (true) {
            System.out.println("\nChoose a level from 1 to 5:");
            int level = scanner.nextInt();

            String wordToGuess = getRandomWord(level); // Get a random word for the chosen level
            StringBuilder guessedWord = new StringBuilder("_".repeat(wordToGuess.length())); // Initialize guessed word
                                                                                             // with underscores
            System.out.println("Guess the word: " + guessedWord);

            while (true) {
                System.out.print("Enter a letter from a to z: ");
                char guess = scanner.next().charAt(0);

                if (wordToGuess.indexOf(guess) != -1) { // Correct guess
                    System.out.println("Correct guess!");

                    updateGuessedWord(wordToGuess, guessedWord, guess); // Update the guessed word with the correct
                                                                        // guess
                    System.out.println("Word: " + guessedWord);

                    if (!guessedWord.toString().contains("_")) { // All letters guessed correctly
                        int damage = LEVEL_DAMAGE[level - 1]; // Calculate the damage based on the chosen level
                        executionerHP -= damage; // Decrease the executioner's HP
                        // System.out.println("The executioner's HP: " + executionerHP);

                        if (executionerHP <= 0) {
                            System.out.println("You dealth " + damage + " damage!");
                            System.out.println("You win! The executioner's HP reached 0.");
                            break;
                        } else {
                            System.out.println("You dealth " + damage + " damage!");
                            System.out.println("Player HP left: " + playerHP + "  Enemy HP left: " + executionerHP);
                            playerHP = MAX_HP; // Reset player HP
                            break;
                        }
                    }
                } else {
                    System.out.println("Wrong guess! You lose 1 HP.");
                    playerHP--; // Decrease player HP

                    System.out.println("Word: " + guessedWord);
                    System.out.println("You have " + playerHP + " HP remaining.");

                    if (playerHP <= 0) {
                        System.out.println("You lose! Your HP reached 0.");
                        break;
                    }
                }
            }

            if (executionerHP <= 0 || playerHP <= 0) {
                break;
            }
        }

        System.out.println("\nGame over.");
        scanner.close();
    }

    private static String getRandomWord(int level) {
        String[] wordArray;

        switch (level) {
            case 1:
                wordArray = LEVEL_1_WORDS;
                break;
            case 2:
                wordArray = LEVEL_2_WORDS;
                break;
            case 3:
                wordArray = LEVEL_3_WORDS;
                break;
            case 4:
                wordArray = LEVEL_4_WORDS;
                break;
            case 5:
                wordArray = LEVEL_5_WORDS;
                break;
            default:
                throw new IllegalArgumentException("Invalid level: " + level);
        }

        Random random = new Random();
        int randomIndex = random.nextInt(wordArray.length);
        return wordArray[randomIndex];
    }

    private static void updateGuessedWord(String wordToGuess, StringBuilder guessedWord, char guess) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                guessedWord.setCharAt(i, guess); // Replace underscore with the correct guess at the corresponding
                                                 // position
            }
        }
    }
}
