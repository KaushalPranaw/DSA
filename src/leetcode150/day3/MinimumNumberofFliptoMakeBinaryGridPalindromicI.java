package leetcode150.day3;

public class MinimumNumberofFliptoMakeBinaryGridPalindromicI {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(new MinimumNumberofFliptoMakeBinaryGridPalindromicI().minFlips(grid));

    }

    public int minFlips(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int rowFlips = 0;
        for (int i = 0; i < rows; i++) {
            rowFlips += findMinFlips(grid[i]);
        }
        int colFlips = 0;
        for (int i = 0; i < cols; i++) {
            int[] column = new int[rows];
            for (int j = 0; j < rows; j++) {
                column[j] = grid[j][i];
            }
            colFlips += findMinFlips(column);
        }
        return Math.min(rowFlips, colFlips);

    }

    int findMinFlips(int[] arr) {
        int flips = 0;
        int start = 0, end = arr.length - start - 1;
        while (start < end) {
            if (arr[start] != arr[end])
                flips++;
            start++;
            end--;
        }
        return flips;
    }


}
