package leetcode150.day7;

public class WordSearch {
    public static void main(String[] args) {
        char board[][] = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(new WordSearch().exist(board, word));

    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0) && dfs(board, word, row, col, 0)) {
                    return true;
                }

            }
        }
        return false;

    }

    private boolean dfs(char[][] board, String word, int row, int col, int count) {
        if (count == word.length())
            return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(count)) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = ' ';

        boolean found = dfs(board, word, row + 1, col, count + 1) ||
                dfs(board, word, row - 1, col, count + 1) ||
                dfs(board, word, row, col + 1, count + 1) ||
                dfs(board, word, row, col - 1, count + 1);
        board[row][col] = temp;
        return found;


    }
}
