import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1978. 소수 찾기
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;
        for(int i=0; i<n; i++){
            int x = array[i];
            if(x == 2 || x > 1 && isSosu(x)){
                count++;
            }
        }

        System.out.println(count);
    }
    
    private static boolean isSosu(int x) {
        for(int i=2; i <x; i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}
