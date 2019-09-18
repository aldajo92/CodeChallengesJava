package container_water;

public class Main {
    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea2(heights));
    }

    public static int maxArea(int[] height) {
        // TODO: brute force solution
        //  - Validate null and size 0, 1, 2
        //  - Iterate over each elements using two pivots
        //  - Compare areas
        if (height == null) {
            return 0;
        }
        int n = height.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            if (height[0] < height[1]) {
                return height[0];
            } else {
                return height[1];
            }
        }

        int maxArea = 0;
        int currentArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int base = j - i;
                int initial = height[i];
                int pivot = height[j];

                if (initial < pivot) {
                    currentArea = initial * base;
                } else {
                    currentArea = pivot * base;
                }

                if (currentArea > maxArea) {
                    maxArea = currentArea;
                }
            }
        }
        return maxArea;
    }

    public static int maxArea2(int[] height) {
        if (height == null) return 0;
        if (height.length == 1) return 0;
        if (height.length == 2) return Math.min(height[0], height[1]);

        int l = 0, r = height.length - 1;

        int maxArea = 0;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
            if(height[l] < height[r]){
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
