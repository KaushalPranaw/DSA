package leetcode150.day4;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));

    }

    public int maxSubArray(int[] nums) {

        //kadane algo
        //take one sum variable and intialize it as 0
        //so sum=0
        //one more variable max=first element
        //max=nums[0]
        //now iterate and check
        //if sum<0 then sum=0
        //if max<sum then max=sum

        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
}
