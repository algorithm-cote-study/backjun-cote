import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

class Solution {
    
    static Map<String,Location> locationMap = Map.of(
        "U", new Location(0, 1),
        "D", new Location(0,-1),
        "R", new Location(1,0),
        "L", new Location(-1,0)
    );
    
    public int solution(String dirs) {
        Location currentLocation = new Location(0,0);
        Set<Location> visitedList = new HashSet<>();
        
        String[] splitedDir = dirs.split("");
        
        for(String dir: splitedDir){
            Location move = locationMap.get(dir);
            int moveX = move.x + currentLocation.x;
            int moveY = move.y + currentLocation.y;
            
            if(moveX <= 5 && moveX >= -5 && moveY <=5 && moveY >= -5){
            
            
                visitedList.add(new Location(moveX
                                             , moveY
                                             , currentLocation.x
                                             , currentLocation.y));
                visitedList.add(new Location(currentLocation.x
                                             , currentLocation.y
                                             , moveX
                                             , moveY));
                
                currentLocation.update(moveX, moveY, currentLocation.x, currentLocation.y);
            }
            
        }
        
        return visitedList.size()/2;
    }
    
    static class Location{
        
        private int x;
        private int y;
        private int beforeX;
        private int beforeY;
        
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public Location(int x, int y,int beforeX, int beforeY){
            this.x = x;
            this.y = y;
            this.beforeX = beforeX;
            this.beforeY = beforeY;
        }
        
        public void update(int x, int y,int beforeX, int beforeY){
            this.x = x;
            this.y = y;
            this.beforeX = beforeX;
            this.beforeY = beforeY;
        }
        
        @Override
        public boolean equals(Object o){
            Location target = (Location) o;
            return this.x == target.x 
                && this.y == target.y
                && this.beforeX == target.beforeX
                && this.beforeY == target.beforeY;   
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x,y,beforeX,beforeY);
        }
       
    }
}