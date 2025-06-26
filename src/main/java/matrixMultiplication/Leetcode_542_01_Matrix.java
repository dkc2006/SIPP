package matrixMultiplication;

import java.util.*;
public class Leetcode_542_01_Matrix {
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        int inf = m + n;

        // Top-left to bottom-right pass
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = inf;
                    if (i > 0)
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    if (j > 0)
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }

        // Bottom-right to top-left pass
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i < m - 1)
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                if (j < n - 1)
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
            }
        }

        return dp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int[][] result = updateMatrix(mat);

        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }
}
