package com.tw.guess;

import java.util.*;

public class Guess {

    private static final int GUESS_TIMES = 6;
    private static final String GUESS_SUCCESS_FLAG = "4A0B";
    private static final String GAME_OVER = "Game Over";
    private static Map<String, String> tipsMap = new HashMap<>();
    private CompareNumber compareNumber;
    private List<String> numberList;
    private String generatedNumber;

    static {
        tipsMap.put(GUESS_SUCCESS_FLAG, "Congratulations!");
    }

    public Guess(NumberGenerator numberGenerator) {
        this.compareNumber = new CompareNumber();
        this.numberList = new ArrayList<>();
        this.generatedNumber = numberGenerator.generate();
    }

    public boolean isContainsDuplicateNumbersInStrNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (i != number.lastIndexOf(number.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public String guess(String guessNumber) {
        numberList.add(guessNumber);
        String result = compareNumber.compare(generatedNumber, guessNumber);
        return GUESS_SUCCESS_FLAG.equals(result) ? tipsMap.get(GUESS_SUCCESS_FLAG) : result;
    }

    public String scanner(Scanner scanner) {
        //TODO 该处不太明确是否需要判断用户输入是否为数字以及长度,需求中没作要求
        return scanner.next();
    }

    public String run(Scanner scanner) {
        while (numberList.size() < GUESS_TIMES) {
            String number = scanner(scanner);
            String result = guess(number);
            if (tipsMap.get(GUESS_SUCCESS_FLAG).equals(result)) {
                return result;
            }
            continueInput(number, result);
        }
        return GAME_OVER;
    }

    public void continueInput(String number, String result){
        if (isContainsDuplicateNumbersInStrNumber(number)) {
            print("Cannot input duplicate numbers!");
            print("\nPlease input your number(X):");
        } else {
            if (numberList.size() != GUESS_TIMES) {
                print(result);
                print("\nPlease input your number(X):");
            }
        }

    }

    public static void print(String str) {
        System.out.println(str);
    }

    public void start() {
        print("Welcome!\n\nPlease input your number(6):");
    }
}
