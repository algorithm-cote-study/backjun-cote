import java.util.*;


class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];

        Map<String, Integer> idxMap = new HashMap<>();
        Map<String, String> parentMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            idxMap.put(enroll[i], i);
            parentMap.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            String cur = seller[i];
            int money = amount[i] * 100;

            while (!cur.equals("-") && money > 0) {
                int up = money / 10;
                answer[idxMap.get(cur)] += money - up;
                cur = parentMap.get(cur);
                money = up;
            }
        }

        return answer;
    }
}