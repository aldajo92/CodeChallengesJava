package array_greater;

import java.util.Scanner;
import java.util.stream.Stream;

class Solution {

    static Integer[] solution(Integer[] N, int K) {
        // Your solution goes here.
        int size = N.length;

        int start = 0;
        int end = K - 1;

        Integer[] current = new Integer[K];
        Integer[] result = new Integer[K];

        while (end < size){
            for (int i = 0; i < K; i++) {
                current[i] = N[start+i];
            }

            if (result[0] == null){
                replace(current,result, K);
            }

            for (int i = 0; i < K; i++) {
                if(current[i] > result[i]){
                    replace(current, result, K);
                }
            }

            end++;
            start++;
        }
        return result;
    }

    static void replace(Integer[] income, Integer[] outcome, int size){
        for (int i = 0; i < size; i++) {
            outcome[i] = income[i];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] N = {5};
        Integer K = 1;
        System.out.print(fromIntArray(solution(N, K)));
    }

    private static Integer[] getIntegerArray(String str) {
        return Stream.of(str.split("\\,"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }

    private static String fromIntArray(Integer[] input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            sb.append(input[i]);
            if (i < input.length - 1) {
                sb.append(',');
            }
        }
        return sb.toString();
    }
}
