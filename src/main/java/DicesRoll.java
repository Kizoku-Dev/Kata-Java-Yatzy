import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;

public class DicesRoll {

    private final List<Integer> dicesResults;

    public DicesRoll(int dice1, int dice2, int dice3, int dice4, int dice5) {
        this.dicesResults = Arrays.asList(dice1, dice2, dice3, dice4, dice5);
    }

    public int sum() {
        return dicesResults.stream()
                .reduce(0, Integer::sum);
    }

    private Map<Integer, Integer> countDices() {
        return dicesResults.stream()
                .collect(Collectors.groupingBy(d -> d, reducing(0, e -> 1, Integer::sum)));
    }

    public int countDice(int dice) {
        return countDices().getOrDefault(dice, 0);
    }

    public List<Integer> findPairs() {
        return countDices().entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .map(Map.Entry::getKey)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
