package com.tw.guess;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class GuessTest {

    private Guess guess;

    @Before
    public void setUp() {
        Random random = mock(Random.class);
        when(random.nextInt(10)).thenReturn(1, 2, 3, 4);

        NumberGenerator numberGenerator = new NumberGenerator(random);
        guess = new Guess(numberGenerator);
    }

    @Test
    public void should_return_congratulations_when_input_1234_and_generate_number_is_1234() {
        String guessNumber = "1234";

        String result = guess.guess(guessNumber);

        assertThat(result, is("Congratulations!"));
    }

    @Test
    public void should_return_game_over_when_input_wrong_six_times_and_generate_number_is_1234() {
        String[] guessNumbers = {"2345", "2346", "2347", "2348", "2341", "2134"};
        String result = "";

        for (String number : guessNumbers){
            result = guess.guess(number);
        }

        assertThat(result, is("Game Over"));
    }

    @Test
    public void should_return_can_not_input_duplicate_numbers_when_input_2345_two_times_and_generate_number_is_1234() {
        String[] guessNumbers = {"2345", "2345"};
        String result = "";

        for (String number : guessNumbers) {
            result = guess.guess(number);
        }

        assertThat(result, is("Cannot input duplicate numbers!"));
    }

    @Test
    public void should_return_3A0B_when_input_5234_and_generate_number_is_1234() {
        String guessNumber = "5234";

        String result = guess.guess(guessNumber);

        assertThat(result, is("3A0B"));
    }

    @Test
    public void should_return_1234_when_scanner_1234(){
        Guess guess = mock(Guess.class);
        when(guess.scanner()).thenReturn("1234");

        String number = guess.scanner();

        assertThat(number, is("1234"));
    }


}
