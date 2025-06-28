package matrixMultiplication;

import java.util.*;
public class UniquePaths_Leetcode_61 {
    public static int paths(int m, int n){
        int [][] dp = new int[m][n];

        for(int [] arr:dp){
            Arrays.fill(arr,1);
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(paths(m,n));
    }
}
