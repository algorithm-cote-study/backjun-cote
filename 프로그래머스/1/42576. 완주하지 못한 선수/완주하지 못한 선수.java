import java.util.Map;
import java.util.HashMap;


class Solution {
    public String solution(String[] participants, String[] completions) {
        String answer = "";
        
        Map<String,Integer> map = new HashMap<>();
        
        for(String completion : completions){
            map.put(completion, map.getOrDefault(completion,0)+1);
        }
        
        for(String participant : participants){
            Integer count = map.get(participant);
            
            if(count == null || count == 0){
                
                return participant;
            }
            map.put(participant, count-1);
        }
        
        
        return answer;
    }
}