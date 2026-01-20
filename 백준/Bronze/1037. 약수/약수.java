import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < cnt; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x < min) {
                min = x;
            }
            if (x > max) {
                max = x;
            }
        }

        long n = (long) min * (long) max;
        System.out.println(n);
    }
}