package matrixMultiplication;

import java.util.Scanner;

public class MatrixChainMultiplication_Recursive {
    static int min(int[] arr, int i, int j) {
        if (i + 1 == j) {
            return 0;
        }
        int res = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            int cost = min(arr, i, k) + min(arr, k, j) + arr[i] * arr[k] * arr[j];
            res = Math.min(cost, res);
        }
       return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Multiplication is " + min(arr, 0, n-1));
    }
}
