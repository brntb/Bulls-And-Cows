package com.slinger;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    //code is generated by iterating over the pseudoRandomNumber in reverse order and adding unique digits.
    //at most 10 unique digits can be generated
    public String generateCode(int length) {
        boolean isGenerating = true;
        boolean isGenerated = false;
        long pseudoRandomNumber;
        String strNumber;
        List<Integer> digits = new ArrayList<>();

        while (isGenerating) {
            pseudoRandomNumber = System.nanoTime();
            strNumber = String.valueOf(pseudoRandomNumber);

            for (int i = strNumber.length() - 1; i >= 0; i--) {
                int currentDigit = Character.getNumericValue(strNumber.charAt(i));

                //check if we have seen this digit or if first digit is 0, if so ignore it
                if (digits.contains(currentDigit) || (digits.isEmpty() && currentDigit == 0)) {
                    continue;
                } else {
                    digits.add(currentDigit);
                }

                //check if we have reached desired size
                //and break for loop if we have
                if (digits.size() == length) {
                    isGenerated = true;
                    break;
                }
            }

            if (isGenerated) { //if we have desired length, break loop else go again
                isGenerating = false;
            }
        }

        //have desired digits in list, need to convert to string and return result
        StringBuilder result = new StringBuilder();
        digits.forEach(result::append);
        return result.toString();
    }
}