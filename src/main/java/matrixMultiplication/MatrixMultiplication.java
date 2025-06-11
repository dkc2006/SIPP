package matrixMultiplication;

public class MatrixMultiplication {
    public static void main(String[] args) {

        // 2*2 Matrix

        int[][] A = new int[][]{{1, 2}, {3, 4}};
        int[][] B = new int[][]{{5, 6}, {7, 8}};

        int[][] C = new int[2][2];

        // Matrix multiplication logic
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                C[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    C[i][j] += A[i][k] * B[k][j]; // T.C -> Total operations = n * n * n = O(n³)
                }
            }
        }

        // Print result
        System.out.println("Resultant 2x2 Matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
