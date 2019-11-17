package bigger_one_google;

import java.util.Scanner;
import java.util.stream.Stream;

class Solution {

    static int solution(Integer[] A) {
        int max = 0;
        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        // Read from stdin, solve the problem, write answer to stdout.
        Integer[] A = {5, 3, 2, 1, 8, 7, 6, 5, 4, 9, 8, 7, 7, 6, 5, 4, 3, 2, 1};

        System.out.print(solution(A));
    }

    private static Integer[] getIntegerArray(String str) {
        return Stream.of(str.split("\\,"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
}