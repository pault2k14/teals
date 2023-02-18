import java.util.Scanner;
import java.util.Random;

public class FullRockPaperScissors {

    public static void main(String args[]){
        FullRockPaperScissors rockPaperScissors = new FullRockPaperScissors();
        rockPaperScissors.GiveInstructions();
        rockPaperScissors.PlayGame();
    }

    private void GiveInstructions() {
        System.out.println("Welcome to the Rock Paper Scissors game!");
        System.out.println("Here are the rules:");
        System.out.println("The player and the computer will pick rock, paper, or scissors.");
        System.out.println("Paper beats rock.");
        System.out.println("Rock beats scissors");
        System.out.println("Scissors beat paper.");
    }

    private void PlayGame() {
        String playAgain = "Y";

        while(playAgain.equals("Y") || playAgain.equals("y")) {
            int player = PlayersTurn();
            int computer = ComputersTurn();
            DetermineWinner(computer, player);
            Scanner userInputScanner = new Scanner(System.in);  // Create a Scanner object
            System.out.print("Would you like to play again (Y/N)? ");
            playAgain = userInputScanner.nextLine();  // Read user input
        }
    }

    private int PlayersTurn() {
        boolean isValid = false;
        int choice = 0;
        Scanner userInputScanner = new Scanner(System.in);  // Create a Scanner object

        while(isValid == false) {
            System.out.print("Enter 1 for Rock, 2 for Paper, 3 for Scissors: ");
            String userChoice = userInputScanner.nextLine();  // Read user input

            try {
                choice = Integer.parseInt(userChoice);
                if(choice == 1 || choice == 2 || choice == 3) {
                    isValid = true;
                } else {
                    System.out.print("Invalid Input");
                }
            } catch(Exception e) {
                System.out.print("Invalid Input");
            }
        }

        return choice;
    }

    private int ComputersTurn() {
        Random random = new Random();
        // Formula of random.nextInt(max - min + 1) + min to get an integer in the range of min to max
        int choice = random.nextInt(3 - 1 + 1) + 1;
        return choice;
    }

    private String ConvertChoiceToString(int choice) {
        if(choice == 1) {
            return "rock";
        } else if(choice == 2) {
            return "paper";
        } else if(choice == 3) {
            return "scissors";
        }

        return null;
    }

    private void DetermineWinner(int computerChoice, int userChoice) {
        String stringUserChoice = ConvertChoiceToString(userChoice);
        String stringComputerChoice = ConvertChoiceToString(computerChoice);
        String resultString = "The player chose " + stringUserChoice + " and the computer chose " + stringComputerChoice + ", ";

        if(stringUserChoice.equals(stringComputerChoice)) {
            System.out.println(resultString + "it is a tie!");
        } else if(stringUserChoice.equals("rock")) {
            if(stringComputerChoice.equals("paper")) {
                System.out.println(resultString + "the computer wins!");
            } else if(stringComputerChoice.equals("scissors")) {
                System.out.println(resultString + "you win!");
            }
        } else if(stringUserChoice.equals("paper")) {
            if(stringComputerChoice.equals("rock")) {
                System.out.println(resultString + "you win!");
            } else if(stringComputerChoice.equals("scissors")) {
                System.out.println(resultString + "the computer wins!");
            }
        } else if(stringUserChoice.equals("scissors")) {
            if(stringComputerChoice.equals("paper")) {
                System.out.println(resultString + "you win!");
            } else if(stringComputerChoice.equals("rock")) {
                System.out.println(resultString + "the computer wins!");
            }
        }
    }

}

