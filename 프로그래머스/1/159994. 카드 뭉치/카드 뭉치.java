import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        Deque<String> cardQueue = new ArrayDeque<>();
        Deque<String> card2Queue = new ArrayDeque<>();
        
        for(int i = 0;i <cards1.length; i++){
            cardQueue.offer(cards1[i]);
        }
        for(int i = 0;i <cards2.length; i++){
            card2Queue.offer(cards2[i]);
        }
        int current = 0;
        while(
            current < goal.length
            && (goal[current].equals(cardQueue.peek()) 
            || goal[current].equals(card2Queue.peek()))){
            
            if(goal[current].equals(cardQueue.peek())){
                current++;
                cardQueue.poll();
                continue;
            }
            
            if(goal[current].equals(card2Queue.peek())){
                current++;
                card2Queue.poll();
                continue;
            }
            
           
        
        }
        System.out.println(current);
        return current<goal.length ? "No" :"Yes";
    }
    
}