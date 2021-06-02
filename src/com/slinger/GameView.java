package com.slinger;

import java.util.Scanner;

public class GameView {

    private final Scanner scanner;

    public GameView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getCodeLength() {
        System.out.println("Please, enter the secret code's length:");
        return Integer.parseInt(scanner.nextLine());
    }

    public void startGameMessage() {
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

    public void printInvalidLength(int length) {
        System.out.println("Error: can't generate a secret number with a length of " + length + " because there aren't enough unique digits.");
    }

}
