import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;


class Solution {
    
     public int solution(String s) {
        int answer = 0;

        String[] inputs = s.split("");
        Queue<String> queue = new ArrayDeque<>();

        for (String input : inputs) {
            queue.offer(input);
        }

        int count = queue.size();

        for (int i = 0; i < count; i++) {

            if (isCollect(queue)) {
                answer++;
            }

            queue.offer(queue.poll());
        }

        return answer;
    }

    private boolean isCollect(Queue<String> queue) {
        Stack<String> stack = new Stack<>();
        for (String s : queue) {
            if (s.equals("[") || s.equals("{") || s.equals("(")) {
                stack.push(s);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                String target = stack.pop();
                if (s.equals("]") && !target.equals("[")) {
                    return false;
                }
                if (s.equals("}") && !target.equals("{")) {
                    return false;
                }
                if (s.equals(")") && !target.equals("(")) {
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }

}