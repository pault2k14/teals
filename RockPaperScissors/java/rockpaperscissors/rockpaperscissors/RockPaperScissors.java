import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void main(String args[]){
        System.out.println("Welcome to the Rock Paper Scissors game!");
        System.out.println("Here are the rules:");
        System.out.println("The player and the computer will pick rock, paper, or scissors.");
        System.out.println("Paper beats rock.");
        System.out.println("Rock beats scissors");
        System.out.println("Scissors beat paper.");

        Scanner userInputScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter 1 for Rock, 2 for Paper, 3 for Scissors: ");
        String userChoice = userInputScanner.nextLine();  // Read user input
        int intUserChoice = Integer.parseInt(userChoice);
        String stringUserChoice = ConvertChoiceToString(intUserChoice);

        Random random = new Random();
        // Formula of random.nextInt(max - min + 1) + min to get an integer in the range of min to max
        int intComputerChoice = random.nextInt(3 - 1 + 1) + 1;
        String stringComputerChoice = ConvertChoiceToString(intComputerChoice);
        DetermineWinner(stringComputerChoice, stringUserChoice);
    }

    public static void DetermineWinner(String computerChoice, String userChoice) {
        String resultString = "The player chose " + userChoice + " and the computer chose " + computerChoice + ", ";

        if(userChoice.equals(computerChoice)) {
            System.out.println(resultString + "it is a tie!");
        } else if(userChoice.equals("rock")) {
            if(computerChoice.equals("paper")) {
                System.out.println(resultString + "the computer wins!");
            } else if(computerChoice.equals("scissors")) {
                System.out.println(resultString + "you win!");
            }
        } else if(userChoice.equals("paper")) {
            if(computerChoice.equals("rock")) {
                System.out.println(resultString + "you win!");
            } else if(computerChoice.equals("scissors")) {
                System.out.println(resultString + "the computer wins!");
            }
        } else if(userChoice.equals("scissors")) {
            if(computerChoice.equals("paper")) {
                System.out.println(resultString + "you win!");
            } else if(computerChoice.equals("rock")) {
                System.out.println(resultString + "the computer wins!");
            }
        }
    }


    public static String ConvertChoiceToString(int choice) {
        if(choice == 1) {
            return "rock";
        } else if(choice == 2) {
            return "paper";
        } else if(choice == 3) {
            return "scissors";
        }

        return null;
    }
}
