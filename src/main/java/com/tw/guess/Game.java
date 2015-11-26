package com.tw.guess;

import java.util.Random;
import java.util.Scanner;


public class Game {

    public static void main(String[] args){
        Guess guess = new Guess(new NumberGenerator(new Random()));

        guess.start();

        Guess.print(guess.run(new Scanner(System.in)));
    }
}
