import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        String[] input = s.split("");
        
        int count = input.length;
        Stack<String> stack = new Stack();
        for(String inputString : input){
            
            if(inputString.equals("(")){
                stack.push(inputString);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                
                String target = stack.pop();
                if(target.equals(inputString)){
                    return false;
                }
                
            }
            
            count--;
            
            if(stack.size()> count){
                return false;
            }
            
        }
        
        return answer;
    }
}