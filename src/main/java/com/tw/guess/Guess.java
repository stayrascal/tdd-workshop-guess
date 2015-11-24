package com.tw.guess;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Guess {

    private CompareNumber compareNumber;
    private Set<String> numberSet;
    private String generatedNumber;
    private Scanner scanner;

    public Guess(NumberGenerator numberGenerator) {
        this.compareNumber = new CompareNumber();
        this.numberSet = new HashSet<>();
        this.scanner = new Scanner(System.in);
        this.generatedNumber = numberGenerator.generate();
    }

    public String guess(String guessNumber) {

        if (numberSet.contains(guessNumber)) {
            return "Cannot input duplicate numbers!";
        }

        numberSet.add(guessNumber);

        String result = compareNumber.compare(generatedNumber, guessNumber);

        if ("4A0B".equals(result)) {
            return "Congratulations!";
        }

        return numberSet.size() == 6 ? "Game Over" : result;
    }

    public String scanner() {
        return scanner.nextLine();

    }


}
