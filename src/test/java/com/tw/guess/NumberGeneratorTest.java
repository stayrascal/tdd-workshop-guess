package com.tw.guess;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class NumberGeneratorTest {

    private NumberGenerator numberGenerator;

    @Before
    public void setUp() {
        numberGenerator = new NumberGenerator(new Random());
    }

    @Test
    public void the_return_string_length_should_be_4() {
        String generated = numberGenerator.generate();

        assertThat(generated.length(), is(4));
    }

    @Test
    public void the_return_string_should_be_number() throws NumberFormatException {
        String generated = numberGenerator.generate();

        try {
            Integer.parseInt(generated);
        } catch (NumberFormatException e) {
            fail("Not a number");
        }
    }

    @Test
    public void the_return_string_should_have_different_diggits() {
        String generated = numberGenerator.generate();
        Set numberSet = new HashSet<>();
        for (int i = 0; i < generated.length(); i++) {
            numberSet.add(generated.charAt(i));
        }

        assertThat(numberSet.size(), is(4));
    }

    @Test
    public void the_return_string_should_be_random() {
        int generatedTimes = 5;
        Set numbersSet = new HashSet<>();
        for (int i = 0; i < generatedTimes; i++) {
            numbersSet.add(numberGenerator.generate());
        }

        assertThat(numbersSet.size(), is(generatedTimes));
    }
}
