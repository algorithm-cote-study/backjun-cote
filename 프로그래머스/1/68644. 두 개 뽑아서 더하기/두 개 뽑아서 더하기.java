import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

class Solution {

    public int[] solution(int[] numbers) {
        int[] answer = {};

        Set<Integer> numberSet = new TreeSet<>();
        // HashSet 을 쓰고 추후에 return할때 stream에서 sorted하는데 어떤게 더 좋은지
        // for문 돌리는 것보다 stream 더 좋은지 ?

        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                numberSet.add(numbers[i] + numbers[j]);
            }
        }

        answer = new int[numberSet.size()];

        int i = 0;
        for (Integer num : numberSet) {
            answer[i] = num;
            i++;
        }

        return answer;
    }


}