package next_permutation;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] values = {1, 2, 3};
        int[] values = {1, 1};
        System.out.println(Arrays.toString(values));
        new Main().nextPermutation(values);

    }

    public void nextPermutation(int[] nums) {
        // TODO:
        //  - validate edge cases for input : null, empty, size 1
        //  - scan from right to left, find the first element that is less than its previous one (p).
        //  - scan from right to left, find the first element that is greater than p (q).
        //  - swap p and q
        //  - reverse elements [p+1, nums.length]

        if (nums == null || nums.length == 0 || nums.length == 1) return;
        int n = nums.length;

        int i = n - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            if (j < 0) return;
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
