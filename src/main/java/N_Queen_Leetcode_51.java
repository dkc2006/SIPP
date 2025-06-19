import java.util.*;

public class N_Queen_Leetcode_51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        List<List<String>> result = sol.solveNQueens(n);

        int count = 1;
        for (List<String> board : result) {
            System.out.println("Solution " + count + ":");
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
            count++;
        }
    }
}

class Solution {
    public boolean isSafe(int row, int col, char[][] board) {
        int n = board.length;

        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') return false;
        }

        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') return false;
        }

        int r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--) {
            if (board[r][c] == 'Q') return false;
        }

        r = row;
        for (int c = col; c < n && r >= 0; c++, r--) {
            if (board[r][c] == 'Q') return false;
        }

        r = row;
        for (int c = col; c >= 0 && r < n; c--, r++) {
            if (board[r][c] == 'Q') return false;
        }

        r = row;
        for (int c = col; c < n && r < n; c++, r++) {
            if (board[r][c] == 'Q') return false;
        }

        return true;
    }

    public void saveBoard(char[][] board, List<List<String>> allBoards) {
        List<String> newBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = "";
            for (int j = 0; j < board[0].length; j++) {
                row += board[i][j];
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }

    public void helper(char[][] board, List<List<String>> allBoards, int col) {
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, allBoards, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        helper(board, allBoards, 0);
        return allBoards;
    }
}
