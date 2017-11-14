import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class L720 {
    @Test
    public void longestWord() throws Exception {
        Solution solution = new Solution();

        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        assertTrue("apple".equals(solution.longestWord(words)));
    }

    class Solution {

        /**
         * Naive Solution. Put string into priority queue based on length of word, and validate from
         * the longest string. Use {@code HashSet} to determine whether a substring exists in words
         * list.
         *
         * @param words Words list to check.
         *
         * @return The longest word in {@code words} that can be built one character at a time by
         * other words in words
         */
        public String longestWord(String[] words) {
            HashSet<String> set = new HashSet<>();
            set.addAll(Arrays.asList(words));

            PriorityQueue<String> x = new PriorityQueue<>(
                    (o1, o2) -> {
                        if (o1.length() < o2.length())
                            return 1;
                        if (o1.length() > o2.length())
                            return -1;
                        return String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
                    }
            );

            x.addAll(Arrays.asList(words));

            String ret = null;
            String w = x.poll();
            while (!x.isEmpty()) {
                if (ret == null)
                    ret = w;
                if (w.length() == 1)
                    return ret;

                String subw = w.substring(0, w.length() - 1);

                if (set.contains(subw)) {
                    w = subw;
                } else {
                    ret = null;
                    w = x.poll();
                }
            }

            return "";
        }
    }
}