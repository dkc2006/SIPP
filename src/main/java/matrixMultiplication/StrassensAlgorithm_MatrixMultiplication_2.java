package matrixMultiplication;

public class StrassensAlgorithm_MatrixMultiplication_2 {
    public static void main(String[] args) {

        // 4*4 Matrix Multiplication

        int[][] A = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] B = {
                {17, 18, 19, 20},
                {21, 22, 23, 24},
                {25, 26, 27, 28},
                {29, 30, 31, 32}
        };

        int[][] C = strassenMultiply(A, B);

        System.out.println("Resultant Matrix:");
        for (int[] row : C) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    // Recursive Strassen Multiply
    public static int[][] strassenMultiply(int[][] A, int[][] B) {
        int n = A.length;

        // Base case: 1x1 matrix
        if (n == 1) {
            int[][] result = { { A[0][0] * B[0][0] } };
            return result;
        }

        int newSize = n / 2;

        // Divide A and B into 4 sub-matrices
        int[][] A11 = new int[newSize][newSize];
        int[][] A12 = new int[newSize][newSize];
        int[][] A21 = new int[newSize][newSize];
        int[][] A22 = new int[newSize][newSize];

        int[][] B11 = new int[newSize][newSize];
        int[][] B12 = new int[newSize][newSize];
        int[][] B21 = new int[newSize][newSize];
        int[][] B22 = new int[newSize][newSize];

        // Splitting matrices
        split(A, A11, 0, 0);
        split(A, A12, 0, newSize);
        split(A, A21, newSize, 0);
        split(A, A22, newSize, newSize);

        split(B, B11, 0, 0);
        split(B, B12, 0, newSize);
        split(B, B21, newSize, 0);
        split(B, B22, newSize, newSize);

        // 7 Strassen recursive multiplications
        int[][] M1 = strassenMultiply(add(A11, A22), add(B11, B22));
        int[][] M2 = strassenMultiply(add(A21, A22), B11);
        int[][] M3 = strassenMultiply(A11, subtract(B12, B22));
        int[][] M4 = strassenMultiply(A22, subtract(B21, B11));
        int[][] M5 = strassenMultiply(add(A11, A12), B22);
        int[][] M6 = strassenMultiply(subtract(A21, A11), add(B11, B12));
        int[][] M7 = strassenMultiply(subtract(A12, A22), add(B21, B22));

        // Calculating result submatrices
        int[][] C11 = add(subtract(add(M1, M4), M5), M7);
        int[][] C12 = add(M3, M5);
        int[][] C21 = add(M2, M4);
        int[][] C22 = add(subtract(add(M1, M3), M2), M6);

        // Combine 4 submatrices into result matrix
        int[][] C = new int[n][n];
        join(C11, C, 0, 0);
        join(C12, C, 0, newSize);
        join(C21, C, newSize, 0);
        join(C22, C, newSize, newSize);

        return C;
    }

    // Helper methods
    public static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }

    public static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }

    public static void split(int[][] P, int[][] C, int iB, int jB) {
        for (int i = 0; i < C.length; i++)
            for (int j = 0; j < C.length; j++)
                C[i][j] = P[i + iB][j + jB];
    }

    public static void join(int[][] C, int[][] P, int iB, int jB) {
        for (int i = 0; i < C.length; i++)
            for (int j = 0; j < C.length; j++)
                P[i + iB][j + jB] = C[i][j];
    }
}
