package com.tw.guess;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CompareNumberTest {

    private CompareNumber compareNumber;

    @Before
    public void setUp() {
        compareNumber = new CompareNumber();
    }

    @Test
    public void should_return_4A0B_when_compare_1234_and_1234() {
        String generatedNumber = "1234";
        String guessedNumber = "1234";

        String result = compareNumber.compare(generatedNumber, guessedNumber);

        assertThat(result, is("4A0B"));
    }

    @Test
    public void should_return_0A4B_when_compare_1234_and_4321() {
        String generatedNumber = "1234";
        String guessedNumber = "4321";

        String result = compareNumber.compare(generatedNumber, guessedNumber);

        assertThat(result, is("0A4B"));
    }

    @Test
    public void should_return_0A0B_when_compare_1234_and_5678() {
        String generatedNumber = "1234";
        String guessedNumber = "5678";

        String result = compareNumber.compare(generatedNumber, guessedNumber);

        assertThat(result, is("0A0B"));
    }

    @Test
    public void shoud_return_3A0B_when_compare_1234_and_5234() {
        String generatedNumber = "1234";
        String guessedNumber = "5234";

        String result = compareNumber.compare(generatedNumber, guessedNumber);

        assertThat(result, is("3A0B"));
    }
}
