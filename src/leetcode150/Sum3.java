package leetcode150;

import java.util.*;

public class Sum3 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Sum3().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //x+y+z=0
        //x+y=-z to solve in O(n)2
        //sort nums
        //iterate for n-2
        //take two pointer left & right
        //left is i+1 and right is nums.length-1
        //and check if left+right = -sum then add in result
        //else left+right >-sum then right--
        //else left++

        Set<List<Integer>> result = new HashSet<>();
        if (nums.length < 3)
            return new ArrayList<>(result);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(result);

    }
}
