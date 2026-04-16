import java.util.*;

class Solution {
	boolean solution(String str) {
		String [] strArr = str.split("");
		Stack<String> stack = new Stack<>();
		
		if(strArr.length%2!=0) {
			return false;
		}
		
		for(String s : strArr) {
        	if("(".equals(s)) {
        		stack.push("0");
        	} else {
        		if(!stack.isEmpty()) {
        			stack.pop();
        		}
        	}
        }
		
		if(stack.isEmpty()) {
			return true;
		} 
		return false;
    }
}