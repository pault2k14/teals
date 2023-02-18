import random

def main():
    print("Welcome to the Rock Paper Scissors game!")
    print("Here are the rules:")
    print("The player and the computer will pick rock, paper, or scissors.")
    print("Paper beats rock.")
    print("Rock beats scissors")
    print("Scissors beat paper.")

    user_choice = input("Enter 1 for Rock, 2 for Paper, 3 for Scissors: ")
    int_user_choice = int(user_choice)
    string_user_choice = convertChoiceToString(int_user_choice)
    int_computer_choice = random.randint(1, 3)
    string_computer_choice = convertChoiceToString(int_computer_choice)
    determineWinner(string_computer_choice, string_user_choice)


def determineWinner(computer_choice, user_choice):
    result_string = "The player chose " + user_choice + " and the computer chose " + computer_choice + ", "

    if user_choice == computer_choice:
        print(result_string + "it is a tie!")
    elif user_choice == "rock":
        if computer_choice == "paper":
            print(result_string + "the computer wins!")
        elif computer_choice == "scissors":
            print(result_string + "you win!")
    elif user_choice == "paper":
        if computer_choice == "rock":
            print(result_string + "you win!")
        elif computer_choice == "scissors":
            print(result_string + "the computer wins!")
    elif user_choice == "scissors":
        if computer_choice == "paper":
            print(result_string + "you win!")
        elif computer_choice == "rock":
            print(result_string + "the computer wins!")

def convertChoiceToString(choice):
    if choice == 1:
        return "rock"
    elif choice == 2:
        return "paper"
    elif choice == 3:
        return "scissors"

main()