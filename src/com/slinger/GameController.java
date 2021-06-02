package com.slinger;

public class GameController {
    private final GameView view;
    private final CodeGenerator generator;

    public GameController(GameView view) {
        this.view = view;
        this.generator = new CodeGenerator();
    }

    public void play() {
        boolean isGuessing = true;
        int turn = 1;

        //get code length before guessing starts
        int codeLength = view.getCodeLength();

        if (codeLength > 10) {
            view.printInvalidLength(codeLength);
            return;
        }

        //generate code for game to use and print start message
        String code = generator.generateCode(codeLength);
        view.startGameMessage();

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
