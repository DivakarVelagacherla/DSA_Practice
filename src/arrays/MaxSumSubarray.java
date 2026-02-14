package arrays;

import java.lang.Math;

public class MaxSumSubarray {

    public static int maxSum(int[] arr, int k) {
        // Your code here
        int left = 1;
        int right = k;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < k; i++){
            sum = sum + arr[i];
        }

        maxSum = Math.max(sum, maxSum);
        while(right < arr.length){
            sum = sum - arr[left-1] + arr[right];
            maxSum = Math.max(sum, maxSum);
            left++;
            right++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        // Test case 1
        int result1 = maxSum(new int[]{2, 1, 5, 1, 3, 2}, 3);
        assert result1 == 9 : "Test case 1 failed: expected 9, got " + result1;
        System.out.println("Test 1 passed: " + result1);

        // Test case 2
        int result2 = maxSum(new int[]{2, 3, 4, 1, 5}, 2);
        assert result2 == 7 : "Test case 2 failed: expected 7, got " + result2;
        System.out.println("Test 2 passed: " + result2);

        // Test case 3
        int result3 = maxSum(new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20}, 4);
        assert result3 == 39 : "Test case 3 failed: expected 39, got " + result3;
        System.out.println("Test 3 passed: " + result3);

        System.out.println("\nAll tests passed! ✓");
    }
}