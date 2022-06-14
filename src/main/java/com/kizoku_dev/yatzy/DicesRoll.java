package com.kizoku_dev.yatzy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

/**
 * DiceRoll class used to manipulate results of a dice roll.
 * Represents a DiceRoll.
 */
class DicesRoll {

    private static final List<Integer> SMALL_STRAIGTH = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> LARGE_STRAIGHT = Arrays.asList(2, 3, 4, 5, 6);

    private final List<Integer> dicesResults;

    /**
     * Instantiates a new Dices roll.
     *
     * @param dice1 the dice 1
     * @param dice2 the dice 2
     * @param dice3 the dice 3
     * @param dice4 the dice 4
     * @param dice5 the dice 5
     */
    public DicesRoll(int dice1, int dice2, int dice3, int dice4, int dice5) {
        this.dicesResults = Arrays.asList(dice1, dice2, dice3, dice4, dice5);
    }

    /**
     * Returns the sum of all dices.
     *
     * @return the sum of all dices
     */
    public int sum() {
        return dicesResults.stream()
                .reduce(0, Integer::sum);
    }

    private Map<Integer, Integer> countDices() {
        return dicesResults.stream()
                .collect(Collectors.groupingBy(d -> d, reducing(0, e -> 1, Integer::sum)));
    }

    /**
     * Count dice occurrences.
     *
     * @param dice the dice value to count
     * @return the number of occurrences for the given value
     */
    public int countDice(int dice) {
        return countDices().getOrDefault(dice, 0);
    }

    private Stream<Integer> getDiceValueWithCountGreaterThan(int count) {
        return countDices().entrySet().stream()
                .filter(entry -> entry.getValue() >= count)
                .map(Map.Entry::getKey);
    }

    /**
     * Find pairs of dice values.
     *
     * @return the list of pairs ordered by value desc.
     */
    public List<Integer> findPairsDesc() {
        return getDiceValueWithCountGreaterThan(2)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    /**
     * Gets dice with count greater than provided number.
     *
     * @param count the count
     * @return the dice with count greater than provided number, if there is no match, 0 is returned
     */
    public int getDiceWithCountGreaterThan(int count) {
        return getDiceValueWithCountGreaterThan(count)
                .findFirst()
                .orElse(0);
    }

    private List<Integer> sortAsc() {
        return dicesResults.stream().sorted().collect(toList());
    }

    public boolean ifSmallStraight() {
        return sortAsc().equals(SMALL_STRAIGTH);
    }

    public boolean ifLargeStraight() {
        return sortAsc().equals(LARGE_STRAIGHT);
    }

    /**
     * Is dices roll a yatzy.
     *
     * @return true if yatzy, false otherwise.
     */
    public boolean isYatzy() {
        return countDices()
                .values()
                .stream()
                .anyMatch(count -> count == 5);
    }

    /**
     * Is dices roll a full house.
     *
     * @return true if full house, false otherwise.
     */
    public boolean isFullHouse() {
        int threeOfAKindValue = getDiceWithCountGreaterThan(3);
        int pairValue = findPairsDesc().stream().findFirst().orElse(0);
        return threeOfAKindValue != 0 && pairValue != 0 && threeOfAKindValue != pairValue;
    }
}
