package dp.oneDArray;

import java.util.Arrays;

public class MaximumAlternatingSubsequenceSum {
    public static void main(String[] args) {
        int nums[] = {4, 2, 5, 3};
        System.out.println(new MaximumAlternatingSubsequenceSum().maxAlternatingSum(nums));
    }

    //bottom up
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n + 1][2];//either even or odd
        for (int i = 1; i < n + 1; i++) {
            //even
            dp[i][0] = Math.max(dp[i - 1][1] - nums[i - 1], dp[i - 1][0]);

            //odd
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i - 1], dp[i - 1][1]);

        }

        return Math.max(dp[n][0], dp[n][1]);


    }


    //recu+memo
    //dp[n+1][2]
    //n+1 *2==> n*2==>n==>O(n) TC
    /*public long maxAlternatingSum(int[] nums) {
        int flag = 1; //1= +ve num, 0 = -ve num
        int idx = 0;
        long[][] dp = new long[nums.length + 1][2]; // in each row we save the value and its flag value
        for (int i = 0; i <= nums.length; i++)
            Arrays.fill(dp[i], -1);
        return solve(nums, idx, flag, dp);
    }
    private long solve(int[] nums, int idx, int flag, long[][] dp) {
        if (idx >= nums.length)
            return 0;
        if (dp[idx][flag] != -1)
            return dp[idx][flag];
        long skip = solve(nums, idx + 1, flag, dp);
        int val = nums[idx];
        if (flag == 0)//means false
        {
            val = -val;
        }
        long take = val + solve(nums, idx + 1, 1 - flag, dp);
        return dp[idx][flag] = Math.max(skip, take);
    }*/
}
