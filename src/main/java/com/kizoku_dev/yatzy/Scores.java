package com.kizoku_dev.yatzy;

import java.util.List;

/**
 * The type com.kizoku_dev.yatzy.Scores.
 */
public class Scores {

    private Scores() {
        /* Default private constructor */
    }

    /**
     * Get chance score.
     *
     * @param roll the dices roll
     * @return the score
     */
    public static int chance(DicesRoll roll) {
        return roll.sum();
    }

    /**
     * get yatzy score.
     *
     * @param roll the dices roll
     * @return the score
     */
    public static int yatzy(DicesRoll roll) {
        return roll.isYatzy() ? 50 : 0;
    }

    /**
     * Get ones score.
     *
     * @param roll the roll
     * @return the score
     */
    public static int ones(DicesRoll roll) {
        return roll.countDice(1);
    }

    /**
     * get twos score.
     *
     * @param roll the roll
     * @return the score
     */
    public static int twos(DicesRoll roll) {
        return roll.countDice(2) * 2;
    }

    /**
     * Get threes score.
     *
     * @param roll the roll
     * @return the score
     */
    public static int threes(DicesRoll roll) {
        return roll.countDice(3) * 3;
    }

    /**
     * Get fours score.
     *
     * @param roll the roll
     * @return the score
     */
    public static int fours(DicesRoll roll) {
        return roll.countDice(4) * 4;
    }

    /**
     * Get fives score.
     *
     * @param roll the roll
     * @return the score
     */
    public static int fives(DicesRoll roll) {
        return roll.countDice(5) * 5;
    }

    /**
     * Get sixes score.
     *
     * @param roll the roll
     * @return the score
     */
    public static int sixes(DicesRoll roll) {
        return roll.countDice(6) * 6;
    }

    /**
     * Get one pair score.
     *
     * @param roll the dices roll
     * @return the score
     */
    public static int onePair(DicesRoll roll) {
        List<Integer> pairs = roll.findPairsDesc();
        return pairs.isEmpty() ? 0 : pairs.get(0) * 2;
    }

    /**
     * Get two pairs score.
     *
     * @param roll the dices roll
     * @return the score
     */
    public static int twoPairs(DicesRoll roll) {
        List<Integer> pairs = roll.findPairsDesc();
        return pairs.isEmpty() ? 0 : pairs.get(0) * 2 + pairs.get(1) * 2;
    }

    /**
     * Get three of a kind score.
     *
     * @param roll the dices roll
     * @return the score
     */
    public static int threeOfAKind(DicesRoll roll) {
        return roll.getDiceWithCountGreaterThan(3) * 3;
    }

    /**
     * Get four of a kind score.
     *
     * @param roll the dices roll
     * @return the score
     */
    public static int fourOfAKind(DicesRoll roll) {
        return roll.getDiceWithCountGreaterThan(3) * 4;
    }

    /**
     * Get small straight score.
     *
     * @param roll the dices roll
     * @return the score
     */
    public static int smallStraight(DicesRoll roll) {
        return roll.ifSmallStraight() ? 15 : 0;
    }

    /**
     * Get large straight score.
     *
     * @param roll the dices roll
     * @return the score
     */
    public static int largeStraight(DicesRoll roll) {
        return roll.ifLargeStraight() ? 20 : 0;
    }

    /**
     * Get full house score.
     *
     * @param roll the dices roll
     * @return the score
     */
    public static int fullHouse(DicesRoll roll) {
        return roll.isFullHouse() ? roll.sum() : 0;
    }
}



