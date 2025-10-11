import java.io.*;
import java.util.*;

public class Main {
    static final int SIEVE_LIMIT = 10_000_000; // 상황에 따라 5e6~2e7 사이로 조절

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int T = fs.nextInt();
        long[] qs = new long[T];
        long maxN = 0;
        for (int i = 0; i < T; i++) {
            qs[i] = fs.nextLong();
            if (qs[i] > maxN) maxN = qs[i];
        }

        StringBuilder sb = new StringBuilder(T * 12);

        if (maxN <= SIEVE_LIMIT) {
            // 전처리: sigma(i)의 누적합 S(n) = sum_{k<=n} sigma(k)
            long[] pref = buildPrefixSigma((int) maxN);
            for (int i = 0; i < T; i++) sb.append(pref[(int) qs[i]]).append('\n');
        } else {
            // 큰 n 포함: 쿼리마다 O(sqrt n)
            for (int i = 0; i < T; i++) sb.append(sumSigmaUpTo(qs[i])).append('\n');
        }

        System.out.print(sb);
    }

    // 에라토스 스타일로 sigma(i) 누적합 O(N log N)
    static long[] buildPrefixSigma(int N) {
        long[] sigma = new long[N + 1];
        Arrays.fill(sigma, 1);
        sigma[0] = 0; // 사용 안함
        // 1의 배수 더하기는 모두 1씩 이미 포함되어 있으므로 아래에서 i부터 시작
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                sigma[j] += i;
            }
        }
        // prefix
        for (int i = 1; i <= N; i++) sigma[i] += sigma[i - 1];
        return sigma;
    }

    // Dirichlet hyperbola 분해: O(sqrt n)
    // F(n) = sum_{i=1..n} i * floor(n/i) 를 구간 묶어서 합산
    static long sumSigmaUpTo(long n) {
        long res = 0;
        long i = 1;
        while (i <= n) {
            long q = n / i;        // 같은 몫 구간
            long r = n / q;        // i..r에서 몫 q가 동일
            long cnt = r - i + 1;
            long sumRange = (i + r) * cnt / 2; // 등차합
            res += q * sumRange;
            i = r + 1;
        }
        return res;
    }

    // 초고속 입력
    static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        long nextLong() throws IOException {
            int c; long sgn = 1, val = 0;
            do { c = read(); } while (c <= 32);
            if (c == '-') { sgn = -1; c = read(); }
            while (c > 32) { val = val * 10 + (c - '0'); c = read(); }
            return val * sgn;
        }
        int nextInt() throws IOException { return (int) nextLong(); }
    }
}