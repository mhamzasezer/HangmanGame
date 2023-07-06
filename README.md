# Hangman Game
This is a simple Hangman Game implemented in Java. The game allows you to guess a word to defeat the executioner. You and the executioner start with a maximum of 10 hit points (HP) each. If your HP reaches 0, you lose the game. If the executioner's HP reaches 0, you win.

## How to Play
1. Run the program.
2. The game will display a welcome message and provide a brief description of the game and its rules.
3. You will be prompted to choose a level from 1 to 5.
4. Based on your chosen level, a random word will be selected for you to guess.
5. The game will display the word with underscores representing the unguessed letters.
6. Enter a letter from 'a' to 'z' as your guess.
7. If your guess is correct, the game will update the displayed word with the correctly guessed letters. You will also deal damage to the executioner based on the chosen level.
8. If your guess is wrong, you will lose 1 HP.
9. The game will continue until either your HP or the executioner's HP reaches 0.
10. If you win, the game will display the damage dealt and declare you the winner.
11. If you lose, the game will display a message stating that your HP reached 0.
12. The game will then be over, and you can choose to play again or exit.

## Game Components

### Levels and Words
The game consists of five levels, each with a set of words. The words become longer and more challenging as you progress to higher levels.

- Level 1: "bear", "cat", "dog", "fish", "frog"
- Level 2: "apple", "banana", "grape", "lemon", "melon"
- Level 3: "cheese", "dragon", "flower", "garden", "monkey"
- Level 4: "elephant", "kangaroo", "penguin", "turtle", "zebra"
- Level 5: "champion", "elephant", "hospital", "jupiter", "rainbow"

### Hit Points (HP)
Both you and the executioner start with a maximum of 10 HP. Each incorrect guess deducts 1 HP from your total. When you correctly guess all the letters in a word, you deal damage to the executioner based on the level you are playing. The damage is calculated as follows:

- Level 1: 2 damage
- Level 2: 4 damage
- Level 3: 6 damage
- Level 4: 8 damage
- Level 5: 10 damage

### Random Word Selection
The `getRandomWord()` method is responsible for selecting a random word based on the chosen level. It uses a switch statement to determine which word array to select from. The method then generates a random index within the selected word array and returns the corresponding word.

### Updating the Guessed Word
The `updateGuessedWord()` method updates the displayed word with the correctly guessed letters. It iterates over each character in the word to guess and replaces the corresponding underscore in the guessed word with the correct guess if a match is found.

## How to play
The code is written in Java and can be compiled and executed using a Java development environment or command-line tools.
