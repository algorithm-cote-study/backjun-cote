import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<String> answer = new ArrayList<>();
        
        List<Music> musicList = new ArrayList<>();
        Map<String,Integer> bestMusic = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            bestMusic.put(genres[i], bestMusic.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        for(int i=0; i<genres.length; i++){
            musicList.add(new Music(genres[i], plays[i], i, bestMusic.get(genres[i])));
        }
        
        
        Collections.sort(musicList);
        
        Map<String, Integer> duplCheck = new HashMap<>();
        
        for(Music m : musicList){
            if(duplCheck.get(m.genre) == null || duplCheck.get(m.genre)  < 2){
                answer.add(String.valueOf(m.number));
            }
            duplCheck.put(m.genre, duplCheck.getOrDefault(m.genre, 0)+1);
        }
        
    
        
        return answer.stream().mapToInt(Integer::parseInt).toArray();
    }
    
    
    public static class Music implements Comparable<Music>{
        // 장르        
        private String genre;
        // 재생횟수
        private int playCount;
        // 고유번호
        private int number;
        
        private int totalCount;
        
        public Music(String genre, int playCount, int number, int totalCount){
            this.genre = genre;
            this.playCount = playCount;
            this.number = number;
            this.totalCount = totalCount;
        }
        
        public void update(int totalCount){
            this.totalCount = totalCount;
        }
        
        @Override
        public int compareTo(Music o){
           if(o.totalCount != this.totalCount){
               return o.totalCount - this.totalCount;
           }
           return o.playCount != this.playCount ? o.playCount - this.playCount : this.number - o.number;
        }
    }
}