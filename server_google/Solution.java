package server_google;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

class Solution {

    static int solution(Integer[] loads) {
        Arrays.sort(loads);
        int sum1 = 0;
        int sum2 = 0;
        int index = loads.length - 1;
        while (index >= 0) {

            if (index == 0) {
                if (Math.abs(sum1 + loads[index]) < Math.abs(sum2 + loads[index])) {
                    sum1 += loads[index];
                } else {
                    sum2 += loads[index];
                }
                break;
            }

            if (loads[index] - loads[index - 1] > 0) {
                sum1 += loads[index];
                sum2 += loads[index - 1];
            } else {
                sum1 += loads[index - 1];
                sum2 += loads[index];
            }

            index -= 2;
        }
        return Math.abs(sum2 - sum1);
    }

    void solution3(int[] servers, int start, int end, int[] balancer) {
        //base
        if (end < start) {
            return;
        } else {
          int value1 = servers[start];
          int value2 = servers[end];


        }
    }

    static int solution2(Integer[] loads) {


        Arrays.sort(loads);
        int sum1 = 0;
        int sum2 = 0;
        int size = loads.length;
        int total = 0;
        //Sum all elements
        for (int i = 0; i < size; i++) {
            total += loads[i];
        }

        //get the ideal balance
        total = total / 2;

        //get the maximum element
        sum1 = loads[loads.length - 1];

        if (total - sum1 < 0) {
            return Math.abs(sum2 - sum1);
        }

        return Math.abs(sum2 - sum1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] loads = {3, 4, 5, 6};

        System.out.print(solution2(loads));
    }

    private static Integer[] getIntegerArray(String str) {
        return Stream.of(str.split("\\,"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
}