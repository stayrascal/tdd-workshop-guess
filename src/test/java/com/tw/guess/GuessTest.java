package com.tw.guess;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*@RunWith(PowerMockRunner.class)
@PrepareForTest(Scanner.class)*/
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
    public void shoud_return_true_when_input_1224() {
        String number = "1224";

        boolean result = guess.isContainsDuplicateNumbersInStrNumber(number);

        assertThat(result, is(true));
    }

    @Test
    public void should_return_false_when_input_2345() {
        String number = "2345";

        boolean result = guess.isContainsDuplicateNumbersInStrNumber(number);

        assertThat(result, is(false));
    }

    @Test
    public void should_return_congratulations_when_input_1234_and_generate_number_is_1234() {
        String guessNumber = "1234";

        String result = guess.guess(guessNumber);

        assertThat(result, is("Congratulations!"));
    }

    @Test
    public void should_return_correct_response_when_input_wrong_six_times_and_generate_number_is_1234() {
        String[] guessNumbers = {"2345", "5678", "4321", "1234"};
        String[] expectedResults = {"0A3B", "0A0B", "0A4B", "Congratulations!"};
        String result;

        for (int i = 0; i < guessNumbers.length; i++) {
            result = guess.guess(guessNumbers[i]);

            assertThat(result, is(expectedResults[i]));
        }
    }

    @Test
    public void should_return_1234_when_scanner_1234() {
        Scanner scanner = new Scanner("1234");

        String result = guess.scanner(scanner);

        assertThat(result, is("1234"));
    }

    @Test
    public void should_return_congratulations_when_last_scanner_1234_and_generate_number_is_1234() {
       /* Scanner scanner = PowerMockito.mock(Scanner.class);
        PowerMockito.when(scanner.nextLine()).thenReturn("1234");*/
        String str = "1245-1236-1235-1235-1235-1234";
        Scanner scanner = new Scanner(str).useDelimiter("-");

        String result = guess.run(scanner);
        assertThat(result, is("Congratulations!"));
    }

    @Test
    public void should_return_game_over_when_input_wrong_six_time_and_generate_number_is_1234() {
        String str = "1245-1236-1235-1235-1235-1235";
        Scanner scanner = new Scanner(str).useDelimiter("-");

        String result = guess.run(scanner);
        assertThat(result, is("Game Over"));
    }

    @Test
    public void should_return_false_when_input_12345() {
        String number = "12345";

        boolean result = guess.isRightFormatOfInputNumber(number);

        assertThat(result, is(false));
    }

    @Test
    public void should_return_false_when_input_abcd() {
        String number = "abcd";

        boolean result = guess.isRightFormatOfInputNumber(number);

        assertThat(result, is(false));
    }

    @Test
    public void should_return_false_when_input_1223() {
        String number = "1223";

        boolean result = guess.isRightFormatOfInputNumber(number);

        assertThat(result, is(false));
    }


}
