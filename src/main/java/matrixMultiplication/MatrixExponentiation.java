// Java Program to find the Nth fibonacci number using 
// Matrix Exponentiation

public class MatrixExponentiation {

    static final int MOD = 1000000007;

    // Function to multiply two 2x2 matrices
    public static void multiply(long[][] A, long[][] B) {
        // Matrix to store the result
        long[][] C = new long[2][2];

        // Matrix multiplication
        C[0][0] = (A[0][0] * B[0][0] + A[0][1] * B[1][0]) % MOD;
        C[0][1] = (A[0][0] * B[0][1] + A[0][1] * B[1][1]) % MOD;
        C[1][0] = (A[1][0] * B[0][0] + A[1][1] * B[1][0]) % MOD;
        C[1][1] = (A[1][0] * B[0][1] + A[1][1] * B[1][1]) % MOD;

        // Copy the result back to the first matrix
        for (int i = 0; i < 2; i++) {
            System.arraycopy(C[i], 0, A[i], 0, 2);
        }
    }

    // Function to find (Matrix M ^ expo)
    public static long[][] power(long[][] M, int expo) {
        // Initialize result with identity matrix
        long[][] ans = {{1, 0}, {0, 1}};

        // Fast exponentiation
        while (expo > 0) {
            if ((expo & 1) != 0) {
                multiply(ans, M);
            }
            multiply(M, M);
            expo >>= 1;
        }

        return ans;
    }

    // Function to find the nth Fibonacci number
    public static int nthFibonacci(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }

        long[][] M = {{1, 1}, {1, 0}};
        // F(0) = 1, F(1) = 1
        long[][] F = {{1, 0}, {0, 0}};

        // Multiply matrix M (n - 1) times
        long[][] res = power(M, n - 1);

        // Multiply resultant with matrix F
        multiply(res, F);

        return (int) ((res[0][0]) % MOD);
    }

    public static void main(String[] args) {
        // Sample input
        int n = 3;

        // Print nth Fibonacci number
        System.out.println(nthFibonacci(n));
    }
}