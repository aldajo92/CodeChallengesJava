package two_sums;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        Integer[] arr = {5, 1, 2, 3, 4};
        Integer[] solution = twoSums(arr, 7);
        System.out.println(String.format("%s, %s", solution[0], solution[1]));
    }

    static Integer[] twoSums(Integer[] arr, Integer target) {
        Integer[] result = new Integer[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int difference = target - arr[i];
            if (map.containsKey(difference)) {
//                result[0] = i;
//                result[1] = map.get(difference);
                result[0] = arr[i];
                result[1] = arr[map.get(difference)];
                return result;
            }

            map.put(arr[i], i);
        }

        return result;
    }

}
