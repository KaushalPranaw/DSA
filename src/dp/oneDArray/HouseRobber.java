package dp.oneDArray;

public class HouseRobber {


    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{1, 2, 3, 1}));
    }

    //constant time
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1)
            return nums[0];

        //not having any house: i=0
        int prevOfPrev = 0;

        //1 house: i=1 means pahla ghar;
        int prev = nums[0];

        int cur = 0;

        for (int i = 2; i <= n; i++) {
            int steal = nums[i - 1] + prevOfPrev;
            int skip = prev;

            cur = Math.max(steal, skip);
            prevOfPrev = prev;
            prev = cur;
        }
        return cur;
    }

    //bottom up
    /*public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];

        int dp[] = new int[n + 1];
        //dp[i] means max stolen money till ith house
        //no house: i=0
        dp[0] = 0;

        //1 house: i=1 means pahla ghar;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            int steal = nums[i - 1] + dp[i - 2];
            int skip = dp[i - 1];

            dp[i] = Math.max(steal, skip);
        }
        return dp[n];
    }*/

    //recur+memo
    /*
    int dp[] = new int[101];
    public int rob(int[] nums) {
        int n = nums.length;
        Arrays.fill(dp, -1);
        return solve(nums, 0, n);

    }
    private int solve(int[] nums, int i, int n) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int steal = nums[i] + solve(nums, i + 2, n);
        int skip = solve(nums, i + 1, n);
        return dp[i] = Math.max(steal, skip);
    }*/

}
