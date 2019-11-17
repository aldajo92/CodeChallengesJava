package rotate_image;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 2, 3, 4, 5, 6},
                        {1, 2, 3, 4, 5, 6},
                        {1, 2, 3, 4, 5, 6},
                        {1, 2, 3, 4, 5, 6},
                        {1, 2, 3, 4, 5, 6},
                        {1, 2, 3, 4, 5, 6}
                };
        printMatrix(matrix);
        new Main().rotate(matrix);
        System.out.println("");
        printMatrix(matrix);
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length == 1) return;
        int n = matrix.length;
        for (int j = 0; j < (n / 2); j++) {
            int m = n - 1 - j;
            for (int i = j; i < m; i++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = matrix[m][n - 1 - i];
                matrix[m][n - 1 - i] = matrix[i][m];
                matrix[i][m] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
