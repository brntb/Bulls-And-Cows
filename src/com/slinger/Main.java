package com.slinger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = "9305";
        String guess = scanner.nextLine();

        int bullCount = 0;
        int cowCount = 0;

        for (int i = 0; i < code.length(); i++) {

            if (code.charAt(i) == guess.charAt(i)) {
                bullCount++;
                continue;
            }

            //check for cows
            for (int j = 0; j < code.length(); j++) {
                if (j != i && code.charAt(i) == guess.charAt(j)) {
                    cowCount++;
                    break;
                }
            }
        }

        printResults(code, bullCount, cowCount);
    }

    private static void printResults(String code, int bulls, int cows) {
        String secretCode = "The secret code is " + code + ".";
        String result;

        if (cows == 0 && bulls == 0) {
            result = "Grade: None.";
        } else if (bulls != 0 && cows != 0) {
            result = String.format("Grade: %d bulls(s) and %d cow(s). ", bulls, cows);
        } else if (bulls != 0) {
            result = String.format("Grade: %d bulls(s). ", bulls);
        } else {
            result = String.format("Grade: %d cow(s). ", cows);
        }

        System.out.println(result + secretCode);
    }

}
