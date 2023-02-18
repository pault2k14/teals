let readline = require('readline');

let rl = readline.createInterface(
    process.stdin, process.stdout);

function main() {
    giveInstructions();
    playGame();
}


function giveInstructions() {
    console.log("Welcome to the Rock Paper Scissors game!");
    console.log("Here are the rules:");
    console.log("The player and the computer will pick rock, paper, or scissors.");
    console.log("Paper beats rock.");
    console.log("Rock beats scissors");
    console.log("Scissors beat paper.");
}


async function playGame() {
    let playAgain = "Y"
    while(playAgain === "Y" || playAgain === "y") {
        let player = await playersTurn();
        let computer = computersTurn();
        determineWinner(computer, player);
        playAgain = await new Promise(resolve => {
            rl.question('Would you like to play again (Y/N)? ', resolve)
        });
    }
    rl.close();
}


async function playersTurn() {
    let isValid = false;
    let choice = 0;

    while (isValid === false) {
        choice = await new Promise(resolve => {
            rl.question('Enter 1 for Rock, 2 for Paper, 3 for Scissors: ', resolve)
        })
        try {
            choice = parseInt(choice);
            if(choice === 1 || choice === 2 || choice === 3) {
                isValid = true;
            } else {
                console.log("Invalid Input");
            }
        } catch(err) {
            console.log("Invalid Input");
        }
    }

    return choice;
}


function computersTurn() {
    return Math.floor(Math.random() * (3 - 1 + 1) + 1);
}


function convertChoiceToString(intChoice) {
    if(intChoice === 1) {
        return "rock";
    } else if(intChoice === 2) {
        return "paper";
    } else if(intChoice === 3) {
        return "scissors";
    }
}


function determineWinner(computerChoice, userChoice) {
    let stringUserChoice = convertChoiceToString(userChoice);
    let stringComputerChoice = convertChoiceToString(computerChoice);

    let resultString = "The player chose " + stringUserChoice + " and the computer chose " + stringComputerChoice + ", ";

    if(stringUserChoice === stringComputerChoice) {
        console.log(resultString + "it is a tie!");
    } else if(stringUserChoice === "rock") {
        if(stringComputerChoice === "paper") {
            console.log(resultString + "the computer wins!");
        } else if(stringComputerChoice === "scissors") {
            console.log(resultString + "you win!");
        }
    } else if(stringUserChoice === "paper") {
        if(stringComputerChoice === "rock") {
            console.log(resultString + "you win!");
        } else if(stringComputerChoice === "scissors") {
            console.log(resultString + "the computer wins!");
        }
    } else if(stringUserChoice === "scissors") {
        if(stringComputerChoice === "paper") {
            console.log(resultString + "you win!");
        } else if(stringComputerChoice === "rock") {
            console.log(resultString + "the computer wins!");
        }
    }
}


main();