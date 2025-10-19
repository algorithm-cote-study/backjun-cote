import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] arr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int E = arr[0];
        int S = arr[1];
        int M = arr[2];

        int index = 1;

        while (true) {
            int compareE = index % 15;
            int compareS = index % 28;
            int compareM = index % 19;

            if (compareE == 0) {
                compareE = 15;
            }
            if (compareS == 0) {
                compareS = 28;
            }
            if (compareM == 0) {
                compareM = 19;
            }

            if (E == compareE && S == compareS && M == compareM) {
                break;
            }
            index++;
        }

        System.out.println(index);

    }


}