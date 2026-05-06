import java.util.Map;
import java.util.HashMap;

class Solution {
    
    public static int count;
    
    public int solution(String[] want, int[] number, String[] discounts) {
        int answer = 0;
        
        count = want.length;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < count; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discounts.length - 10; i++) {
            if (compare(i, discounts, new HashMap<>(map))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean compare(int index, String[] discounts, Map<String, Integer> map) {
        if (index + 10 > discounts.length) {
            return false;
        }
        
        for (int i = index; i < index + 10; i++) {
            String target = discounts[i];
            if (map.containsKey(target)) {
                map.put(target, map.get(target) - 1);
            }
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        
        return true;
    }
}