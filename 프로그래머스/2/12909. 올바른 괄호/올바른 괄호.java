import java.util.Stack;

class Solution {

    boolean solution(String s) {
        boolean answer = true;

        String[] splitString = s.split("");

        Stack<String> stack = new Stack<>();
        for(String str : splitString){
            if(str.startsWith("(")){
                if(stack.size() % 2 == 1){
                    return false;
                }
                stack.push(str);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                String pop = stack.pop();
                if(!pop.equals("(")){
                    return false;
                }
            }
        }
        return answer;
    }
}