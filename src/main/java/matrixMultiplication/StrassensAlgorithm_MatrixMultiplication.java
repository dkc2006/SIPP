package matrixMultiplication;

public class StrassensAlgorithm_MatrixMultiplication {
    public static void main(String[] args) {

        // 2*2 Matrix

        // Matrix A
        int[][] A = {{1, 2}, {3, 4}};

        // Matrix B
        int[][] B = {{5, 6}, {7, 8}};

        // Result Matrix C
        int[][] C = new int[2][2];

        // Elements of A
        int a = A[0][0];
        int b = A[0][1];
        int c = A[1][0];
        int d = A[1][1];

        // Elements of B
        int e = B[0][0];
        int f = B[0][1];
        int g = B[1][0];
        int h = B[1][1];

        // Strassen’s 7 products
        int M1 = (a + d) * (e + h);
        int M2 = (c + d) * e;
        int M3 = a * (f - h);
        int M4 = d * (g - e);
        int M5 = (a + b) * h;
        int M6 = (c - a) * (e + f);
        int M7 = (b - d) * (g + h);

        // Calculating result matrix C
        C[0][0] = M1 + M4 - M5 + M7; // C11
        C[0][1] = M3 + M5;           // C12
        C[1][0] = M2 + M4;           // C21
        C[1][1] = M1 - M2 + M3 + M6; // C22

        // Print Result
        System.out.println("Resultant Matrix using Strassen’s Algorithm:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
