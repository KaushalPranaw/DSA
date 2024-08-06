package leetcode150;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWater().maxArea(height));

    }

    public int maxArea(int[] height) {
        //take two pointers left & right and one area
        //and get area
        //find min in left & right
        //and decrease min pointer and again calculate area if greater then update area
        int left = 0;
        int right = height.length - 1;
        int currentArea = 0, maxArea = 0;
        while (left < right) {
            currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] <= height[right])
                left++;
            else
                right--;

        }
        return maxArea;

    }
}
