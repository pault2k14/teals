let readline = require('readline');

let rl = readline.createInterface(
    process.stdin, process.stdout);

console.log("Welcome to the Rock Paper Scissors game!");
console.log("Here are the rules:");
console.log("The player and the computer will pick rock, paper, or scissors.");
console.log("Paper beats rock.");
console.log("Rock beats scissors");
console.log("Scissors beat paper.");

rl.question('Enter 1 for Rock, 2 for Paper, 3 for Scissors ', (choice) => {
    rl.close();

    let intUserChoice = parseInt(choice);
    let stringUserChoice = convertChoiceToString(intUserChoice);

    let intComputerChoice = Math.floor(Math.random() * (3 - 1 + 1) + 1);
    let stringComputerChoice = convertChoiceToString(intComputerChoice);

    determineWinner(stringComputerChoice, stringUserChoice);
});

function determineWinner(computerChoice, userChoice) {

    let resultString = "The player chose " + userChoice + " and the computer chose " + computerChoice + ", ";

    if(userChoice === computerChoice) {
        console.log(resultString + "it is a tie!");
    } else if(userChoice === "rock") {
        if(computerChoice === "paper") {
            console.log(resultString + "the computer wins!");
        } else if(computerChoice === "scissors") {
            console.log(resultString + "you win!");
        }
    } else if(userChoice === "paper") {
        if(computerChoice === "rock") {
            console.log(resultString + "you win!");
        } else if(computerChoice === "scissors") {
            console.log(resultString + "the computer wins!");
        }
    } else if(userChoice === "scissors") {
        if(computerChoice === "paper") {
            console.log(resultString + "you win!");
        } else if(computerChoice === "rock") {
            console.log(resultString + "the computer wins!");
        }
    }
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
