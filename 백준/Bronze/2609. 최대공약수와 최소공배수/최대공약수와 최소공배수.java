import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = array[0];
        int b = array[1];

        int num = Math.min(a,b);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=num; i > 0; i--){
            if(a % i == 0 && b % i == 0){
                max = Math.max(max,i);
                min = Math.min(min, i * (a/i) * (b/i));
            }
        }

        System.out.println(max);
        System.out.println(min);

    }

}