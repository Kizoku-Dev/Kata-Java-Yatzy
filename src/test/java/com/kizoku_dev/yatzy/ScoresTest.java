package com.kizoku_dev.yatzy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoresTest {

    @Test
    public void testChance() {
        assertEquals(15, Scores.chance(new DicesRoll(2, 3, 4, 5, 1)));
        assertEquals(16, Scores.chance(new DicesRoll(3, 3, 4, 5, 1)));
    }

    @Test
    public void testYatzyScores50() {
        assertEquals(50, Scores.yatzy(new DicesRoll(6, 6, 6, 6, 6)));
    }

    @Test
    public void testYatzyScores0() {
        assertEquals(0, Scores.yatzy(new DicesRoll(6, 6, 6, 6, 3)));
    }

    @Test
    public void testOnes() {
        assertEquals(1, Scores.ones(new DicesRoll(1, 2, 3, 4, 5)));
        assertEquals(2, Scores.ones(new DicesRoll(1, 2, 1, 4, 5)));
        assertEquals(0, Scores.ones(new DicesRoll(6, 2, 2, 4, 5)));
        assertEquals(4, Scores.ones(new DicesRoll(1, 2, 1, 1, 1)));
    }

    @Test
    public void testTwos() {
        assertEquals(4, Scores.twos(new DicesRoll(1, 2, 3, 2, 6)));
        assertEquals(10, Scores.twos(new DicesRoll(2, 2, 2, 2, 2)));
    }

    @Test
    public void testThrees() {
        assertEquals(6, Scores.threes(new DicesRoll(1, 2, 3, 2, 3)));
        assertEquals(12, Scores.threes(new DicesRoll(2, 3, 3, 3, 3)));
    }

    @Test
    public void testFours() {
        assertEquals(12, Scores.fours(new DicesRoll(4, 4, 4, 5, 5)));
        assertEquals(8, Scores.fours(new DicesRoll(4, 4, 5, 5, 5)));
        assertEquals(4, Scores.fours(new DicesRoll(4, 5, 5, 5, 5)));
    }

    @Test
    public void testFives() {
        assertEquals(10, Scores.fives(new DicesRoll(4, 4, 4, 5, 5)));
        assertEquals(15, Scores.fives(new DicesRoll(4, 4, 5, 5, 5)));
        assertEquals(20, Scores.fives(new DicesRoll(4, 5, 5, 5, 5)));
    }

    @Test
    public void testSixes() {
        assertEquals(0, Scores.sixes(new DicesRoll(4, 4, 4, 5, 5)));
        assertEquals(6, Scores.sixes(new DicesRoll(4, 4, 6, 5, 5)));
        assertEquals(18, Scores.sixes(new DicesRoll(6, 5, 6, 6, 5)));
    }

    @Test
    public void testOnePair() {
        assertEquals(6, Scores.onePair(new DicesRoll(3, 4, 3, 5, 6)));
        assertEquals(10, Scores.onePair(new DicesRoll(5, 3, 3, 3, 5)));
        assertEquals(12, Scores.onePair(new DicesRoll(5, 3, 6, 6, 5)));
    }

    @Test
    public void testTwoPairs() {
        assertEquals(16, Scores.twoPairs(new DicesRoll(3, 3, 5, 4, 5)));
        assertEquals(16, Scores.twoPairs(new DicesRoll(3, 3, 5, 5, 5)));
    }

    @Test
    public void testThreeOfAKind() {
        assertEquals(9, Scores.threeOfAKind(new DicesRoll(3, 3, 3, 4, 5)));
        assertEquals(15, Scores.threeOfAKind(new DicesRoll(5, 3, 5, 4, 5)));
        assertEquals(9, Scores.threeOfAKind(new DicesRoll(3, 3, 3, 3, 5)));
    }

    @Test
    public void testFourOfAKind() {
        assertEquals(12, Scores.fourOfAKind(new DicesRoll(3, 3, 3, 3, 5)));
        assertEquals(20, Scores.fourOfAKind(new DicesRoll(5, 5, 5, 4, 5)));
        assertEquals(12, Scores.fourOfAKind(new DicesRoll(3, 3, 3, 3, 3)));
    }

    @Test
    public void testSmallStraight() {
        assertEquals(15, Scores.smallStraight(new DicesRoll(1, 2, 3, 4, 5)));
        assertEquals(15, Scores.smallStraight(new DicesRoll(2, 3, 4, 5, 1)));
        assertEquals(0, Scores.smallStraight(new DicesRoll(1, 2, 2, 4, 5)));
    }

    @Test
    public void testLargeStraight() {
        assertEquals(20, Scores.largeStraight(new DicesRoll(6, 2, 3, 4, 5)));
        assertEquals(20, Scores.largeStraight(new DicesRoll(2, 3, 4, 5, 6)));
        assertEquals(0, Scores.largeStraight(new DicesRoll(1, 2, 2, 4, 5)));
    }

    @Test
    public void testFullHouse() {
        assertEquals(18, Scores.fullHouse(new DicesRoll(6, 2, 2, 2, 6)));
        assertEquals(0, Scores.fullHouse(new DicesRoll(2, 3, 4, 5, 6)));
        assertEquals(0, Scores.fullHouse(new DicesRoll(6, 6, 6, 5, 6)));
    }
}
