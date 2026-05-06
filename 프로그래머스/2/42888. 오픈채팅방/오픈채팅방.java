import java.util.Map;
import java.util.HashMap;

class Solution {
    
    public static String EnterMessage = "{0}님이 들어왔습니다.";
    public static String LeaveMessage = "{0}님이 나갔습니다.";
    
    public String[] solution(String[] records) {
        Map<String, String> nickNameMap = new HashMap<>();
        int count = 0;
        
        for (String record : records) {
            String[] data = record.split(" ");
            if (record.startsWith("Enter")) {
                nickNameMap.put(data[1], data[2]);
                count++;
            } else if (record.startsWith("Leave")) {
                count++;
            } else if (record.startsWith("Change")) {
                nickNameMap.put(data[1], data[2]);
            }
        }
        
        String[] answer = new String[count];
        int i = 0;
        
        for (String record : records) {
            String[] data = record.split(" ");
            if (record.startsWith("Enter")) {
                answer[i++] = EnterMessage.replace("{0}", nickNameMap.get(data[1]));
            } else if (record.startsWith("Leave")) {
                answer[i++] = LeaveMessage.replace("{0}", nickNameMap.get(data[1]));
            }
        }
        
        return answer;
    }
}