import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] input = s.toCharArray();
        
        Stack<Character> stack = new Stack();
        for(Character inputString : input){
            
            if(inputString == '(' ){
                stack.push(inputString);
            }else{
                if(stack.isEmpty() || stack.pop() == inputString){
                    return false;
                }
                
            }
            
        }
    
        
        return stack.isEmpty();
    }
}