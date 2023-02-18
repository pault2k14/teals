import random

def main():
    giveInstructions()
    playGame()


def giveInstructions():
    print("Welcome to the Rock Paper Scissors game!")
    print("Here are the rules:")
    print("The player and the computer will pick rock, paper, or scissors.")
    print("Paper beats rock.")
    print("Rock beats scissors")
    print("Scissors beat paper.")


def playGame():
    play_again = "Y"
    while play_again == "Y" or play_again == "y":
        player = playersTurn()
        computer = computersTurn()
        determineWinner(computer, player)
        play_again = input("Would you like to play again (Y/N)? ")


def playersTurn():
    is_valid = False
    choice = 0

    while is_valid == False:
        user_choice = input("Enter 1 for Rock, 2 for Paper, 3 for Scissors: ")

        try:
            choice = int(user_choice)
            if choice == 1 or choice == 2 or choice == 3:
                is_valid = True
            else:
                print("Invalid input")
        except:
            print("Invalid input")

    return choice


def computersTurn():
    return random.randint(1, 3)


def convertChoiceToString(choice):
    if choice == 1:
        return "rock"
    elif choice == 2:
        return "paper"
    elif choice == 3:
        return "scissors"


def determineWinner(computer_choice, user_choice):
    string_user_choice = convertChoiceToString(user_choice)
    string_computer_choice = convertChoiceToString(computer_choice)
    result_string = "The player chose " + string_user_choice + " and the computer chose " + string_computer_choice + ", "

    if string_user_choice == string_computer_choice:
        print(result_string + "it is a tie!")
    elif string_user_choice == "rock":
        if string_computer_choice == "paper":
            print(result_string + "the computer wins!")
        elif string_computer_choice == "scissors":
            print(result_string + "you win!")
    elif string_user_choice == "paper":
        if string_computer_choice == "rock":
            print(result_string + "you win!")
        elif string_computer_choice == "scissors":
            print(result_string + "the computer wins!")
    elif string_user_choice == "scissors":
        if string_computer_choice == "paper":
            print(result_string + "you win!")
        elif string_computer_choice == "rock":
            print(result_string + "the computer wins!")


main()