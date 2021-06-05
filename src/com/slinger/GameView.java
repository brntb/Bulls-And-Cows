package com.slinger;

import java.util.Scanner;

public class GameView {

    private final Scanner scanner;

    public GameView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getCodeLength() {
        System.out.println("Please, enter the secret code's length:");
        return scanner.nextLine();
    }

    public String getHowManySymbols() {
        System.out.println("Input the number of possible symbols in the code:");
        return scanner.nextLine();
    }

    public void startGameMessage(String code, int symbolCount) {
        String encrypted = code.replaceAll("[0-9a-z]", "*");
        StringBuilder possibleSymbols = new StringBuilder();

        possibleSymbols.append("(");
        //append possible numbers and letters
        if (symbolCount < 10) {
            possibleSymbols.append("0-10");
        } else if (symbolCount == 10){
            possibleSymbols.append("0-9, ").append("a");
        } else {
            possibleSymbols.append("0-9, ").append("a-");

            //using 97 from ascii table to start at a
            int lastLetterNumber = 97 + symbolCount - 11;
            char lastNumber = (char) lastLetterNumber;
            possibleSymbols.append(lastNumber);
        }
        possibleSymbols.append(").");

        System.out.println("The secret is prepared: " + encrypted + " " + possibleSymbols);
        System.out.println("Okay, let's start a game!");
    }

    public String getTurnGuess(int turn) {
        System.out.println("Turn " + turn + ":");
        return scanner.nextLine();
    }

    public void printGrade(String code, int bulls, int cows) {
        String grade;
        String bullStr = bulls == 1 ? " bull" : " bulls";
        String cowStr = cows == 1 ? " cow" : " cows";

        //check for winner
        if (bulls == code.length()) {
            System.out.println("Grade: " + bulls + bullStr);
            System.out.println("Congratulations! You guessed the secret code.");
            return;
        }

        if (cows == 0 && bulls == 0) {
            grade = "Grade: None.";
        } else if (cows != 0 && bulls == 0) {
            grade = "Grade: " + cows + cowStr;
        } else if (cows == 0) {
            grade = "Grade: " + bulls + bullStr;
        } else {
            grade = "Grade: " + bulls + bullStr + " and " + cows + cowStr;
        }

        System.out.println(grade);
    }

    //prints if symbol length is less than code length
    public void symbolLengthError(int codeLength, int symbolLength) {
        System.out.println("Error: it's not possible to generate a code with a length of " + codeLength + " with " + symbolLength + " unique symbols.");
    }

    //prints if symbol length is greater than 36
    public void tooManySymbolsError() {
        System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
    }

    public void notIntegerError(String input) {
        System.out.println("Error: \"" + input + "\" isn't a valid number.");
    }

}
