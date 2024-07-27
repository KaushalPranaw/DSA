package dp.oneDArray;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new HouseRobber2().rob(nums));
    }

    //Approach-1: using Recur+Memo
    /*int dp[];
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);
        dp = new int[n]; // reduce the size of t to match nums
        Arrays.fill(dp, -1);
        int take_0th_case = solve(nums, 0, n - 2);
        dp = new int[n]; // reduce the size of t to match nums
        Arrays.fill(dp, -1);
        int take_1st_case = solve(nums, 1, n - 1);
        return Math.max(take_0th_case, take_1st_case);
    }
    int solve(int[] nums, int i, int n) {
        if (i > n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int taken_ith_position = nums[i] + solve(nums, i + 2, n);
        int skipped_ith_position = solve(nums, i + 1, n);
        return Math.max(taken_ith_position, skipped_ith_position);
    }*/

    //Approach-2: using bottom-up
    /*public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int dp1[] = new int[n + 1];
        //dp[i]=money stolen when you have i houses
        dp1[0] = 0;
        //case -1: take first house
        for (int i = 1; i <= n - 1; i++) {
            int skip = dp1[i - 1];
            int take = nums[i - 1] + (i - 2 >= 0 ? dp1[i - 2] : 0);
            dp1[i] = Math.max(skip, take);
        }
        int result1 = dp1[n - 1];//because last one is skipped
        //case -2: skipped first house, hence we can take last house
        int dp2[] = new int[n + 1];
        dp2[0] = 0;
        dp2[1] = 0;//skipped first house
        for (int i = 2; i <= n; i++) {
            int skip = dp2[i - 1];
            int take = nums[i - 1] + (i - 2 >= 0 ? dp2[i - 2] : 0);
            dp2[i] = Math.max(skip, take);
        }
        int result2 = dp2[n];
        return Math.max(result2, result1);
    }*/

    //Approach-3: using constant time
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        int taken_first_house = solve(nums, 0, n - 2);
        int skipped_first_house = solve(nums, 1, n - 1);
        return Math.max(taken_first_house, skipped_first_house);
    }
    private int solve(int[] nums, int l, int r) {
        int prev = 0, prevPrev = 0;
        for (int i = l; i <= r; i++) {
            int skip = prev;
            int take = nums[i] + prevPrev;
            int temp = Math.max(skip, take);
            prevPrev = prev;
            prev = temp;
        }
        return prev;
    }
}
