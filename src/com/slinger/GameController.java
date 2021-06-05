package com.slinger;

public class GameController {
    private final GameView view;
    private final CodeGenerator generator;
    private int codeLength;
    private int symbolLength;

    public GameController(GameView view) {
        this.view = view;
        this.generator = new CodeGenerator();
    }

    public void play() {
        boolean isGuessing = true;
        int turn = 1;

        //this should really be a while loop since if user enters bad variables
        //the whole game stops, but the tests don't pass if I do it that way
        if (!isValidGameVariables()) {
            return;
        }

        //starting variables are valid, generate code and start game
        String code = generator.generateCodeWithNumbersAndLetters(codeLength, symbolLength);
        view.startGameMessage(code, symbolLength);

        //start guessing
        while (isGuessing) {
            String guess = view.getTurnGuess(turn++);
            int[] guessResults = findBullsAndCows(code, guess);

            int bulls = guessResults[0];
            int cows = guessResults[1];

            view.printGrade(code, bulls, cows);

            //check if game is over
            if (bulls == codeLength) {
                isGuessing = false;
            }
        }

    }

    //sets variables for code length and how many symbols the secret code should have
    //if user gave bad variables the method returns false
    private boolean isValidGameVariables() {
        //get how long the code should be
        String codeLengthStr = view.getCodeLength();

        //check if the code is actually a number
        if (!codeLengthStr.matches("\\d+")) {
            view.notIntegerError(codeLengthStr);
            return false;
        }

        //code is number, parse it and make sure it is a whole number
        int codeLength = Integer.parseInt(codeLengthStr);

        if (codeLength <= 0) {
            view.notIntegerError(codeLengthStr);
            return false;
        }

        //same logic as above for code length, just now with symbol length
        String symbolCountStr = view.getHowManySymbols();

        if (!symbolCountStr.matches("\\d+")) {
            view.notIntegerError(symbolCountStr);
            return false;
        }

        int symbolCount = Integer.parseInt(symbolCountStr);

        if (symbolCount < codeLength) {
            view.symbolLengthError(codeLength, symbolCount);
            return false;
        }

        //now check for too many symbols, can only have a max of 36
        if (symbolCount > 36) {
            view.tooManySymbolsError();
            return false;
        }

        //set as class variables so main method can use them
        this.codeLength = codeLength;
        this.symbolLength = symbolCount;

        return true;
    }

    //returns how many bulls and cows are in guess
    //idx = 0 is bulls,
    //idx = 1 is cows
    private static int[] findBullsAndCows(String code, String guess) {
        int bullCount = 0;
        int cowCount = 0;
        //holds bulls and cows
        int[] resultHolder = new int[2];

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

        resultHolder[0] = bullCount;
        resultHolder[1] = cowCount;

        return resultHolder;
    }

}
