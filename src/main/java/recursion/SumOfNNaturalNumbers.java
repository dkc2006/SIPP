package recursion;

public class SumOfNNaturalNumbers {

    static int fun(int n) {
        if (n == 0) return 0;
        return n + fun(n - 1);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fun(n));
    }
}
