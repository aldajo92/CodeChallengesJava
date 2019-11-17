package server_google;

public class Solution2 {

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 4, 6, 3};
        System.out.println("The minimum difference between two sets is " + findMin(arr));
        System.out.println("The minimum difference between two sets is " + solution(arr));
    }

    public static int findMinRes(Integer[] arr, int i,
                                 int sumCalculated,
                                 int sumTotal) {
        if (i == 0) return Math.abs((sumTotal - sumCalculated) - sumCalculated);

        return Math.min(
                findMinRes(
                        arr,
                        i - 1,
                        sumCalculated + arr[i - 1],
                        sumTotal),
                findMinRes(
                        arr,
                        i - 1,
                        sumCalculated,
                        sumTotal)
        );
    }

    public static int findMin(Integer[] arr) {
        int sumTotal = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++)
            sumTotal += arr[i];

        return findMinRes(arr, n, 0, sumTotal);
    }

    static int solution(Integer[] loads) {
        int n = loads.length;
        int total = 0;
        for (int i = 0; i < n; i++) total += loads[i];
        return minDiff(loads, n, 0, total);
    }

    static int minDiff(Integer[] loads, int i, int sumCalculated, int total) {
        if (i == 0) {
            return Math.abs(total - 2 * sumCalculated);
        }
        return Math.min(
                minDiff(loads, i - 1, sumCalculated + loads[i - 1], total),
                minDiff(loads, i - 1, sumCalculated, total)
        );
    }

}
