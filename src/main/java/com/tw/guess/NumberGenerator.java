package com.tw.guess;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {

    private Random random;

    public NumberGenerator(Random random) {
        this.random = random;
    }

    public String generate() {
        StringBuilder numberStr = new StringBuilder();
        Set<Integer> digits = new HashSet<>();
        while (digits.size() < 4){
            digits.add(random.nextInt(10));
        }
        digits.forEach(numberStr::append);
        return numberStr.toString();
    }
}
