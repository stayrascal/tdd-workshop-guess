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

    public String guess(String guessNumber) {
        numberList.add(guessNumber);
        if (guessNumber.length() != 4){
            return guessNumber;
        }
        String result = compareNumber.compare(generatedNumber, guessNumber);
        if (GUESS_SUCCESS_FLAG.equals(result)) {
            return tipsMap.get(GUESS_SUCCESS_FLAG);
        }
        return numberList.size() == GUESS_TIMES ? GAME_OVER : result;
    }

    public String scanner(Scanner scanner) {
        //TODO 该处不太明确是否需要判断用户输入是否为数字,需求中没作要求
        String number = scanner.nextLine();
        for (int i = 0; i < number.length(); i++) {
            if (i != number.lastIndexOf(number.charAt(i))) {
                return "Cannot input duplicate numbers!";
            }
        }
        return number;
    }

    public String start() {
        return "Welcome!\n\nPlease input your number(6):";
    }

    public String run(Scanner scanner) {
        String result = "";
        while (numberList.size() < GUESS_TIMES) {
            print(numberList.size() + "");
            result = guess(scanner(scanner));
            if (GAME_OVER.equals(result) || tipsMap.get(GUESS_SUCCESS_FLAG).equals(result)) {
                break;
            }
            print(result + "\n\nPlease input your number(X):");
        }
        return result;
    }

    public static void main(String[] args) {
        Guess guess = new Guess(new NumberGenerator(new Random()));

        print(guess.start());

        print(guess.run(new Scanner(System.in)));

    }

    private static void print(String str) {
        System.out.println(str);
    }
}
