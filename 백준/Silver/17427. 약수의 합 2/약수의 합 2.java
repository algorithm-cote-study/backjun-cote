import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long answer = 0;
        long d = 1;

        while (d <= N) {
            long q = N / d;
            long nd = N / q;

            // d부터 nd까지의 합
            long sum = (d + nd) * (nd - d + 1) / 2;

            answer += q * sum;
            d = nd + 1;
        }

        System.out.println(answer);
    }
}