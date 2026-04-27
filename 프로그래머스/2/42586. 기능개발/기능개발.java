import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        StringBuilder answer = new StringBuilder();
        
        int length = progresses.length;
        Deque<Node> queue = new ArrayDeque<>();
        
        for(int i=0;i<length; i++){
            queue.offer(new Node(progresses[i], speeds[i]));
        }
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.progress < 100){
                node.update();
                queue.offerFirst(node);
            }else{
                int count = 1;
                while(!queue.isEmpty()){
                    Node target = queue.poll();
                    if(target.progress + (target.speed*node.count) < 100){
                        target.progress = target.progress + (target.speed*node.count);
                        target.count = node.count;
                        queue.offerFirst(target);
                        break;
                    }
                    count++;
                }
                answer.append(count).append(" ");
            }
        }
      
        return Arrays.stream(answer.toString().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    
    class Node{
    
        private int progress;
        private int speed;
        private int count;
        
        public Node(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
        
        public void update(){
            progress += speed;
            count++;
        }
            
    }
    
}