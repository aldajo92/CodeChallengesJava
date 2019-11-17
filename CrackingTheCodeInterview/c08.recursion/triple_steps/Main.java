import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n1 = 3;
        System.out.println(countWaysB(n1));

        int n2 = 3;
        System.out.println(countWaysC(n2));
    }

    public static int countWaysA(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWaysA(n - 3) + countWaysA(n - 2) + countWaysA(n - 1);
        }
    }

    public static int countWaysB(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return countWaysA(n - 3) + countWaysA(n - 2) + countWaysA(n - 1);
        }
    }

    static int countWaysC(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWaysMemo(n, memo);
    }

    public static int countWaysMemo(int n, int[] memo) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1 + countWaysMemo(1, memo);
        } else if (n == 3) {
            return 1 + countWaysMemo(2, memo) + countWaysMemo(1, memo);
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWaysMemo(n - 3, memo)
                    + countWaysMemo(n - 2, memo)
                    + countWaysMemo(n - 1, memo);
            return memo[n];
        }
    }
}
