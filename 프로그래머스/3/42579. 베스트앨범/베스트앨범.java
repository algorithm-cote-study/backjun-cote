import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        List<BestAlbum> bestAlbumList = new ArrayList<>();
        for(int i=0; i<genres.length; i++){
            map.put( genres[i], map.getOrDefault( genres[i],0 )+plays[i]);
        }
        for(String key : map.keySet()){
            bestAlbumList.add( new BestAlbum(key,map.get( key )) );
        }
        Collections.sort(bestAlbumList);

        for(BestAlbum b : bestAlbumList){
            List<PlaysGenre> playsGenres = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals( b.genre )){
                    playsGenres.add( new PlaysGenre( i,plays[i] ) );
                }
            }
            Collections.sort( playsGenres );
            for(int i=0; i<playsGenres.size(); i++){
                if(i<=1){
                    answer.add(playsGenres.get( i ).index);
                }
            }
        }
        return answer.stream().mapToInt( Integer::valueOf ).toArray();
    }
}

class PlaysGenre implements Comparable<PlaysGenre>{
    int play;
    int index;

    PlaysGenre(int index, int play){
        this.index = index;
        this.play = play;
    }

    @Override
    public int compareTo(PlaysGenre o){
        if(this.play == o.play) return this.index - o.index;
        return o.play - this.play;
    }
}

class BestAlbum implements Comparable<BestAlbum>{
    String genre;
    int count;

    BestAlbum(String genre,int count){
        this.genre = genre;
        this.count = count;
    }

    @Override
    public int compareTo ( BestAlbum o ) {
        return o.count - this.count;
    }

}