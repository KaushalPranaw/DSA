package leetcode150;

import java.util.Arrays;

public class ProductOfArrayItself {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new ProductOfArrayItself().productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];

        for (int i = 0, temp = 1; i < n; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        for (int j = n - 1, temp = 1; j >= 0; j--) {
            result[j] = result[j] * temp;
            temp *= nums[j];
        }
        return result;

    }
/*    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int leftProduct[] = new int[n];
        int rightProduct[] = new int[n];

        for (int i = 0, temp = 1; i < n; i++) {
            leftProduct[i] = temp;
            temp *= nums[i];
        }
        for (int j = n - 1, temp = 1; j >= 0; j--) {
            rightProduct[j] = temp;
            temp *= nums[j];
        }
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }
        return result;

    }*/

}
