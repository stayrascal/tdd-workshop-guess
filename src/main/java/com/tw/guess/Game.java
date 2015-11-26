package com.tw.guess;

import java.util.Random;
import java.util.Scanner;

/**
 * Date: 2015/11/26
 * Time: 16:56
 *
 * @author Rascal
 */
public class Game {

    public static void main(String[] args){
        Guess guess = new Guess(new NumberGenerator(new Random()));

        guess.start();

        Guess.print(guess.run(new Scanner(System.in)));
    }
}
