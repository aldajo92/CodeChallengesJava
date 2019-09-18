package triplete_sum;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] values = {-2, 0, 1, 1, 2};
        System.out.println(findTripletsSum(values, 0));
    }

//    private static List<List<Integer>> findTriplets(int[] nums) {
//        // TODO:
//        //  - validate null and size minor of 3
//        if (nums == null || nums.length < 3) return null;
//        int n = nums.length;
//        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < n - 1; i++) {
//            HashSet<Integer> set = new HashSet<>();
//            for (int j = i + 1; j < n; j++) {
//                int value = -(nums[i] + nums[j]);
//                if (set.contains(value)) {
//                    List<Integer> resultList = new ArrayList<>();
//                    resultList.add(value);
//                    resultList.add(nums[i]);
//                    resultList.add(nums[j]);
//                    list.add(resultList);
//                } else {
//                    set.add(nums[j]);
//                    set.add(nums[i]);
//                }
//            }
//        }
//
//        return list;
//    }

    static List<List<Integer>> findTripletsSum(int[] nums, int value) {
        if (nums == null || nums.length < 3) return null;
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == value) {
                    List<Integer> resultList = new ArrayList<>();
                    resultList.add(nums[i]);
                    resultList.add(nums[l]);
                    resultList.add(nums[r]);
                    if (!list.contains(resultList)) {
                        list.add(resultList);
                    }
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < value) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return list;
    }

}
