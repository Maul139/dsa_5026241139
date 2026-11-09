package Exercise;


import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class Vote {
    static void countVote(String V) {

        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < V.length(); i++) {
            char candidate = V.charAt(i);
            if (count.containsKey(candidate)) {
                count.put(candidate, count.get(candidate) + 1);
            } else {
                count.put(candidate, 1);
            }
        }

        Set<Character> set = new HashSet<>(count.keySet());
        char winner = '\0';
        int maxVote = 0;

        for (Character c : set) {
            int v = count.get(c);
            if (v > maxVote) {
                winner = c;
                maxVote = v;
            }
        }

        System.out.println("Winner: " + winner + " with " + maxVote + " votes");
    }

    public static void main(String[] args) {
        countVote("AABBC");
    }
}