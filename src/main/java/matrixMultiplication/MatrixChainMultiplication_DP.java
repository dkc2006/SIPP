package matrixMultiplication;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixChainMultiplication_DP {

    // Top-level method to start the DP process
    static int mul(int n, int[] arr) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return min(arr, 1, n - 1, dp);
    }

    // Recursive DP function with memoization
    static int min(int[] arr, int i, int j, int[][] dp) {
        if (i == j) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost = min(arr, i, k, dp) + min(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];
            res = Math.min(res, cost);
        }

        return dp[i][j] = res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of elements in array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = mul(n, arr);
        System.out.println("Minimum multiplication is " + ans);
    }
}
