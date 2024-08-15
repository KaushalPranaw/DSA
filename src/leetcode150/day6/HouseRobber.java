package leetcode150.day6;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new HouseRobber().rob(nums));
    }

    //constant space
    public int rob(int[] nums) {

        int prevOfPrev = 0;
        int prev = nums[0];//phla ghar
        int cur = 0;

        for (int i = 2; i <= nums.length; i++) {
            int skipped = prev;
            int robbed = nums[i - 1] + prevOfPrev;
            cur = Math.max(robbed, skipped);
            prevOfPrev = prev;
            prev = cur;

        }
        return cur;

    }

    //bottom up
    /*public int rob(int[] nums) {
        int dp[] = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];//phla ghar

        for (int i = 2; i <= nums.length; i++) {
            int skipped = dp[i - 1];
            int robbed = nums[i - 1] + dp[i - 2];
            dp[i] = Math.max(robbed, skipped);
        }
        return dp[nums.length];

    }*/

    //recu+memo
    /*int dp[] = new int[101];
    public int rob(int[] nums) {
        Arrays.fill(dp, -1);
        return solve(nums, 0);

    }
    private int solve(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != -1)
            return dp[index];
        int skipped = solve(nums, index + 1);
        int robbed = nums[index] + solve(nums, index + 2);
        return dp[index] = Math.max(skipped, robbed);
    }*/
}
