import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/4375
 */
public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                int target = Integer.parseInt(line);
                calculate(target);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void calculate(int target) {
        if (target == 0) return;
        int count = 1;
        int remainder = 1 % target;
        while (remainder != 0) {
            remainder = (remainder * 10 + 1) % target;
            count++;
        }
        System.out.println(count);
    }
}
