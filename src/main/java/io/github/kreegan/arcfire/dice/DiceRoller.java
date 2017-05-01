package io.github.kreegan.arcfire.dice;

import org.springframework.stereotype.Component;

import java.util.OptionalInt;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Component to handle dice rolling
 */
@Component
public class DiceRoller {

    private Random random = new Random();

    /**
     * Rolls the given number and type of dice and returns a comma-separated list of the results
     * @param numSides number of sides on the dice, ie 4, 6, 8, 10, 12, 20, 100, etc
     * @param numDiceToRoll number of dice to roll
     * @return comma-separated list of results
     */
    public String rollDiceIndividually(int numSides, int numDiceToRoll) {

        validateDiceInput(numSides, numDiceToRoll);

        StringBuilder sb = new StringBuilder();
        IntStream intStream = random.ints(1, numSides + 1); // +1 num sides since this value is exclusive
        // Minimize additional object instantiation as much as possible if only 1 die
        if (numDiceToRoll > 1) {
            int index = 1;
            PrimitiveIterator.OfInt iterator = intStream.iterator();
            int val = iterator.nextInt();
            sb.append(val);
            while (index < numDiceToRoll) {
                val = iterator.nextInt();
                sb.append(",");
                sb.append(val);
                index++;
            }
        } else {
            OptionalInt optionalInt = intStream.findFirst();
            sb.append(optionalInt.orElse(1));
        }

        return sb.toString();
    }

    /**
     * Rolls the given number and type of dice and returns the sum of the results
     *
     * @param numSides number of sides on the dice, ie 4, 6, 8, 10, 12, 20, 100, etc
     * @param numDiceToRoll number of dice to roll
     * @return sum of the results
     */
    public int rollDiceAndSum(int numSides, int numDiceToRoll) {

        validateDiceInput(numSides, numDiceToRoll);

        IntStream intStream = random.ints(1, numSides + 1); // +1 num sides since this value is exclusive
        // Minimize additional object instantiation as much as possible if only 1 die
        if (numDiceToRoll > 1) {
            int index = 1;
            int sum = 0;
            PrimitiveIterator.OfInt iterator = intStream.iterator();
            int val = iterator.nextInt();
            sum += val;
            while (index < numDiceToRoll) {
                val = iterator.nextInt();
                if ((Integer.MAX_VALUE - sum) < val) {
                    System.out.println(sum);
                    throw new RuntimeException("Sum cannot exceed " + Integer.MAX_VALUE);
                }
                sum += val;
                index++;
            }
            return sum;
        } else {
            OptionalInt optionalInt = intStream.findFirst();
            return optionalInt.orElse(1);
        }
    }

    /**
     * Rolls the given number and type of dice and returns the sum of the results and the given modifier
     *
     * @param numSides number of sides on the dice, ie 4, 6, 8, 10, 12, 20, 100, etc
     * @param numDiceToRoll number of dice to roll
     * @param modifier number to add or subtract from the results
     * @return sum of the results and modifier
     */
    public int rollDiceAndSumModified(int numSides, int numDiceToRoll, int modifier) {
        return rollDiceAndSum(numSides, numDiceToRoll) + modifier;
    }

    // Handles validation of number of sides specified and number of dice to roll
    private void validateDiceInput(int numSides, int numDiceToRoll) {
        // Input validation, must be 1 or more sides and 1 or more dice
        if (numSides <= 0) {
            throw new IllegalArgumentException("Number of sides must be a positive integer");
        }
        if (numDiceToRoll <= 0) {
            throw new IllegalArgumentException("Number of dice to roll must be a positive integer >= 1");
        }
    }
}
