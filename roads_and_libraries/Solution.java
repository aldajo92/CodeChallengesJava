//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.regex.*;
//
//public class Solution {
//
//    // Complete the roadsAndLibraries function below.
//    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
//        boolean[] visited = new boolean[5];
//        List<List<Integer>> adj = new ArrayList<>();
//
//        dfs(visited, 2);
//        System.out.println(Arrays.toString(visited));
//
//        return 0;
//    }
//
//    static void dfs(boolean[] visited, int index){
//
//    }
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
////        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int q = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int qItr = 0; qItr < q; qItr++) {
//            String[] nmC_libC_road = scanner.nextLine().split(" ");
//
//            int n = Integer.parseInt(nmC_libC_road[0]);
//
//            int m = Integer.parseInt(nmC_libC_road[1]);
//
//            int c_lib = Integer.parseInt(nmC_libC_road[2]);
//
//            int c_road = Integer.parseInt(nmC_libC_road[3]);
//
//            int[][] cities = new int[m][2];
//
//            for (int i = 0; i < m; i++) {
//                String[] citiesRowItems = scanner.nextLine().split(" ");
//                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//                for (int j = 0; j < 2; j++) {
//                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
//                    cities[i][j] = citiesItem;
//                }
//            }
//
//            long result = roadsAndLibraries(n, c_lib, c_road, cities);
//
////            bufferedWriter.write(String.valueOf(result));
////            bufferedWriter.newLine();
//        }
//
////        bufferedWriter.close();
//
//        scanner.close();
//    }
//}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static List<List<Integer>> adj;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();

            adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            visited = new boolean[n];

            int m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                adj.get(city_1 - 1).add(city_2 - 1);
                adj.get(city_2 - 1).add(city_1 - 1);
            }

            System.out.println(roadsAndLibraries(x, y));
        }

        in.close();
    }

    private static long roadsAndLibraries(int x, int y) {
        long cost = 0;

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                count = 0;
                dfs(i);
                if (x > y) {
                    cost += x + y * (count - 1);
                } else {
                    cost += x * count;
                }
            }
        }

        return cost;
    }

    private static void dfs(int i) {
        visited[i] = true;
        count++;

        List<Integer> list = adj.get(i);
        for (int j = 0; j < list.size(); j++) {
            if (!visited[list.get(j)]) {
                dfs(list.get(j));
            }
        }
    }
}