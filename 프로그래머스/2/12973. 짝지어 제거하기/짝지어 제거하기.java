import java.util.Stack;

class Solution{
    
    public int solution(String s){
        int answer = 0;
        
        if(s.length() % 2 != 0) return answer;
        
        if(isTwin(s)){
            answer = 1;
        }

        return answer;
    }
    
    public boolean isTwin(String s){
        
        String[] alphabets = s.split("");
        
        Stack<String> stack = new Stack<>();
        String target = alphabets[0];
        
        for(int i=1; i<alphabets.length; i++){
            if(target.isEmpty()){
                target = alphabets[i];
                continue;
            }
            
            if(!target.equals(alphabets[i])){
                stack.push(target);
                target = alphabets[i];
            }else{
                if(!stack.isEmpty()){
                    target = stack.pop();
                }
            }
        }
    
        return stack.isEmpty();
    }
   
}