package recursion;

import java.util.Scanner;

public class Leetcode_Problem_1823 {
    public static int sol(int n,int k){
        if(n==1){
            return 0;
        }
        return (sol(n - 1, k) + k)%n;
    }
    public static int findTheWinner(int n, int k){
        return sol(n,k)+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(findTheWinner(n,k));
    }
}
