import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(String s) {

        Deque<String> deque = new ArrayDeque<>();
        String[] words = s.split("");
        for (String word : words) {
            if ("(".equals(word)) {
                deque.push(word);
            } else {
                if(deque.isEmpty()) return false;
                deque.pop();
            }
        }
        return deque.isEmpty();
    }
}