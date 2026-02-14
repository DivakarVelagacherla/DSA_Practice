package arrays;

public class SubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        /*
        Problem:
Given an array of positive integers nums and an integer k,
return the number of contiguous subarrays where the product of all
elements is strictly less than k.
         */

        if( k <= 0 ) return 0;
        int product = 1;
//        need no of subarrays;
        int noOfSubArrays = 0;
        int left = 0, right = 0;

        while(right < nums.length){
            product = product * nums[right];
            right++;

//            shrink when invalid
            while(product >= k && left < right) {
                product = product / nums[left];
                left++;
            }

//            now window is valid
            noOfSubArrays = noOfSubArrays + right - left; //since arr length of 2 will have two subarrays.
        }

        return noOfSubArrays;
    }

    public static void main(String[] args) {
        // Test case 1
        int result1 = numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100);
        assert result1 == 8 : "Test 1 failed: expected 8, got " + result1;
        System.out.println("Test 1 passed: " + result1);

        // Test case 2
        int result2 = numSubarrayProductLessThanK(new int[]{1,2,3}, 0);
        assert result2 == 0 : "Test 2 failed: expected 0, got " + result2;
        System.out.println("Test 2 passed: " + result2);

        // Test case 3
        int result3 = numSubarrayProductLessThanK(new int[]{1,1,1}, 1);
        assert result3 == 0 : "Test 3 failed: expected 0, got " + result3;
        System.out.println("Test 3 passed: " + result3);

        // Test case 4: Single element
        int result4 = numSubarrayProductLessThanK(new int[]{5}, 10);
        assert result4 == 1 : "Test 4 failed: expected 1, got " + result4;
        System.out.println("Test 4 passed: " + result4);

        // Test case 5: All valid
        int result5 = numSubarrayProductLessThanK(new int[]{1,2,3}, 100);
        assert result5 == 6 : "Test 5 failed: expected 6, got " + result5;
        System.out.println("Test 5 passed: " + result5);

        System.out.println("\n✓ All tests passed!");
    }
}