package dp.oneDArray.LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));

    }

    //bottom up
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 1);
        int maxLTS = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLTS = Math.max(maxLTS, dp[i]);
                }
            }
        }
        return maxLTS;


    }

    //recu+memo
    /*public int lengthOfLIS(int[] nums) {
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

    }*/


}
