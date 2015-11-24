package com.tw.guess;

public class CompareNumber {
    public String compare(String generatedNumber, String guessedNumber) {
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < generatedNumber.length(); i++) {
            if (guessedNumber.indexOf(generatedNumber.charAt(i)) != -1) {
                if (guessedNumber.indexOf(generatedNumber.charAt(i)) == i) {
                    countA++;
                } else {
                    countB++;
                }
            }
        }
        return countA + "A" + countB + "B";
    }
}
