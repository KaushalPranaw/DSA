/*
package dp.oneDArray.LIS;

public class MaximumLengthofPairChain {
    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(new MaximumLengthofPairChain().findLongestChain(pairs));
    }

    public int findLongestChain(int[][] pairs) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= nums.length; i++)
            Arrays.fill(dp[i], -1);
        int i = 0;
        int prev = -1;
        return solve(i, prev, nums, dp);
    }

    private int solve(int i, int prev, int nums[], int[][] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (prev != -1 && dp[i][prev] != -1) {
            return dp[i][prev];
        }
        int take = 0;
        if (prev == -1 || nums[prev] < nums[i])
            take = 1 + solve(i + 1, i, nums, dp);

        int skip = solve(i + 1, prev, nums, dp);
        if (prev != -1) {
            dp[i][prev] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }
}
*/
