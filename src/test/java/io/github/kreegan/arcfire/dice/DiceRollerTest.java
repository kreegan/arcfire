package io.github.kreegan.arcfire.dice;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for DiceRoller
 */
public class DiceRollerTest {

    private DiceRoller diceRoller = new DiceRoller();

    @Test
    public void rollDiceIndividually_oneDie() {

        String result = diceRoller.rollDiceIndividually(4, 1);

        Integer intResult = Integer.valueOf(result);
        assertTrue(intResult >= 1 && intResult <= 4);
    }

    @Test
    public void rollDiceIndividually_multipleDice() {
        String result = diceRoller.rollDiceIndividually(100, 400);

        String[] split = result.split(",");
        for (String token : split) {
            Integer intResult = Integer.valueOf(token);
            assertTrue(intResult >= 1 && intResult <= 100);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void rollDiceIndividually_badNumSides() {

        diceRoller.rollDiceIndividually(-4, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rollDiceIndividually_badNumDiceToRoll() {

        diceRoller.rollDiceIndividually(8, -1);
    }

    @Test
    public void rollDiceAndSum_oneDie() {

        int result = diceRoller.rollDiceAndSum(4, 1);

        assertTrue(result >= 1 && result <= 4);
    }

    @Test
    public void rollDiceAndSum_multipleDice() {

        int result = diceRoller.rollDiceAndSum(10, 4);

        assertTrue(result >= 4);
    }

    @Test(expected = RuntimeException.class)
    public void rollDiceAndSum_multipleDiceSumTooLarge() {

        diceRoller.rollDiceAndSum(100000, 4000000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rollDiceAndSum_badNumSides() {

        diceRoller.rollDiceAndSum(-4, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rollDiceAndSum_badNumDiceToRoll() {

        diceRoller.rollDiceAndSum(8, -1);
    }

    @Test
    public void rollDiceAndSumModified_oneDie() {

        int result = diceRoller.rollDiceAndSumModified(4, 1, 2);

        assertTrue(result >= 3 && result <= 6);
    }

    @Test
    public void rollDiceAndSumModified_multipleDice() {

        int result = diceRoller.rollDiceAndSumModified(10, 4, 3);

        assertTrue(result >= 7);
    }
}