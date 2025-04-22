import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {

        Hangman self = new Hangman();
        Scanner input = new Scanner(System.in);

        System.out.println("*************************");
        System.out.println("Welcome to Java Hangman!");
        System.out.println("*************************");

        while (true) {

            System.out.print("Enter you word: ");
            String word = input.next().toUpperCase();

            ArrayList<Character> letters = new ArrayList<>();

            int wrongGuesses = 0;

            for(int i = 0; i < word.length(); i++) {
                letters.add('_');
            }
    
            System.out.print("Word: ");
    
            for(char letter : letters) {
                System.out.print(letter + " ");
            }

            while (letters.contains('_') && wrongGuesses < 7) {
                
                System.out.print("\nGuess a letter: ");
                char guess = input.next().toUpperCase().charAt(0);

                if (word.indexOf(guess) >= 0) {            
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == guess) {
                            letters.set(i, guess);
                        }
                    }

                    for(char correctGuess : letters) {
                        System.out.print(correctGuess + " ");
                    }

                    if (!letters.contains('_')) {
                        System.out.println("\nYou win!!!");
                    }
                }

                else {
                    wrongGuesses++;
                    System.out.println(self.getHangmanArt(wrongGuesses));

                    if (wrongGuesses == 7) {
                        System.out.println("You died...");
                        System.out.println("The word was " + word.toUpperCase());
                    }
                }  
            }

            while (true) {

                System.out.print("Do you want to play again?(y/n): ");
                String playAgain = input.next();
                
                if (playAgain.equals("y")) {
                    break;
                }

                else if (playAgain.equals("n")) {
                    System.out.println("Thanks for playing. Bye!");
                }

                else {
                    System.out.println("\nPlease type y or n\n");
                    continue;
                }
            }

            input.close();
        }
    }

    private String getHangmanArt(int wrongGuesses) {
        return switch(wrongGuesses) {

            case 1 -> """
                       O


                      """;

            case 2 -> """
                       O
                       |

                      """;

            case 3 -> """
                       O
                      /|

                      """;

            case 4 -> """
                       O
                      /|\\

                      """;

            case 5 -> """
                       O
                      /|\\
                      /
                      """;

            case 6 -> """
                       O
                      /|\\
                      / \\
                      """;

            case 7 -> """
                       |         
                       O
                      /|\\
                      / \\
                      """;

            default -> "";
        };
    }
}
