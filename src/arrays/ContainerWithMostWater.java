package arrays;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        // Your code here
        int left = 0;
        int right = height.length-1;
        int maxWater = Integer.MIN_VALUE;

        while(left < right){
            int water = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(water, maxWater);

            if(height[left] <= height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        // Test case 1
        int result1 = maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        assert result1 == 49 : "Test case 1 failed: expected 49, got " + result1;
        System.out.println("Test 1 passed: " + result1);

        // Test case 2
        int result2 = maxArea(new int[]{1,1});
        assert result2 == 1 : "Test case 2 failed: expected 1, got " + result2;
        System.out.println("Test 2 passed: " + result2);

        // Test case 3
        int result3 = maxArea(new int[]{4,3,2,1,4});
        assert result3 == 16 : "Test case 3 failed: expected 16, got " + result3;
        System.out.println("Test 3 passed: " + result3);

        System.out.println("\nAll tests passed! ✓");
    }
}