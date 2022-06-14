import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YatzyTest {

    @Test
    public void testChance() {
        assertEquals(15, Yatzy.chance(new DicesRoll(2, 3, 4, 5, 1)));
        assertEquals(16, Yatzy.chance(new DicesRoll(3, 3, 4, 5, 1)));
    }

    @Test
    public void testYatzyScores50() {
        assertEquals(50, Yatzy.yatzy(6, 6, 6, 6, 6));
    }

    @Test
    public void testYatzyScores0() {
        assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3));
    }

    @Test
    public void testOnes() {
        assertEquals(1, Yatzy.ones(new DicesRoll(1, 2, 3, 4, 5)));
        assertEquals(2, Yatzy.ones(new DicesRoll(1, 2, 1, 4, 5)));
        assertEquals(0, Yatzy.ones(new DicesRoll(6, 2, 2, 4, 5)));
        assertEquals(4, Yatzy.ones(new DicesRoll(1, 2, 1, 1, 1)));
    }

    @Test
    public void testTwos() {
        assertEquals(4, Yatzy.twos(new DicesRoll(1, 2, 3, 2, 6)));
        assertEquals(10, Yatzy.twos(new DicesRoll(2, 2, 2, 2, 2)));
    }

    @Test
    public void testThrees() {
        assertEquals(6, Yatzy.threes(new DicesRoll(1, 2, 3, 2, 3)));
        assertEquals(12, Yatzy.threes(new DicesRoll(2, 3, 3, 3, 3)));
    }

    @Test
    public void testFours() {
        assertEquals(12, Yatzy.fours(new DicesRoll(4, 4, 4, 5, 5)));
        assertEquals(8, Yatzy.fours(new DicesRoll(4, 4, 5, 5, 5)));
        assertEquals(4, Yatzy.fours(new DicesRoll(4, 5, 5, 5, 5)));
    }

    @Test
    public void testFives() {
        assertEquals(10, Yatzy.fives(new DicesRoll(4, 4, 4, 5, 5)));
        assertEquals(15, Yatzy.fives(new DicesRoll(4, 4, 5, 5, 5)));
        assertEquals(20, Yatzy.fives(new DicesRoll(4, 5, 5, 5, 5)));
    }

    @Test
    public void testSixes() {
        assertEquals(0, Yatzy.sixes(new DicesRoll(4, 4, 4, 5, 5)));
        assertEquals(6, Yatzy.sixes(new DicesRoll(4, 4, 6, 5, 5)));
        assertEquals(18, Yatzy.sixes(new DicesRoll(6, 5, 6, 6, 5)));
    }

    @Test
    public void testOnePair() {
        assertEquals(6, Yatzy.onePair(new DicesRoll(3, 4, 3, 5, 6)));
        assertEquals(10, Yatzy.onePair(new DicesRoll(5, 3, 3, 3, 5)));
        assertEquals(12, Yatzy.onePair(new DicesRoll(5, 3, 6, 6, 5)));
    }

    @Test
    public void testTwoPairs() {
        assertEquals(16, Yatzy.twoPairs(new DicesRoll(3, 3, 5, 4, 5)));
        assertEquals(16, Yatzy.twoPairs(new DicesRoll(3, 3, 5, 5, 5)));
    }

    @Test
    public void testThreeOfAKind() {
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 4, 5));
        assertEquals(15, Yatzy.threeOfAKind(5, 3, 5, 4, 5));
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 5));
    }

    @Test
    public void testFourOfAkind() {
        assertEquals(12, Yatzy.fourOfAkind(3, 3, 3, 3, 5));
        assertEquals(20, Yatzy.fourOfAkind(5, 5, 5, 4, 5));
        assertEquals(12, Yatzy.fourOfAkind(3, 3, 3, 3, 3));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }
}
