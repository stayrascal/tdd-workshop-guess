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
        Set digits = new HashSet<>();
        while (digits.size() < 4){
            digits.add(random.nextInt(10));
        }
        StringBuilder numberStr = new StringBuilder();
        digits.forEach(numberStr::append);
        return numberStr.toString();
    }
}
