package arrays;

public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        /*
        Problem:
Given a binary array nums and an integer k,
return the maximum number of consecutive 1's
if you can flip at most k zeros.
         */
        int maxLength = 0;
        int flipped = 0;
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] != 1){
                flipped++;
            }

            while(flipped > k){
                if(nums[left] == 0){
                    flipped--;
                }
                left++;
            }

            right++;

            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test case 1
        int result1 = longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
        assert result1 == 6 : "Test 1 failed: expected 6, got " + result1;
        System.out.println("Test 1 passed: " + result1);

        // Test case 2
        int result2 = longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
        assert result2 == 10 : "Test 2 failed: expected 10, got " + result2;
        System.out.println("Test 2 passed: " + result2);

        // Test case 3: No flips allowed
        int result3 = longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1}, 0);
        assert result3 == 4 : "Test 3 failed: expected 4, got " + result3;
        System.out.println("Test 3 passed: " + result3);

        // Test case 4: All zeros
        int result4 = longestOnes(new int[]{0,0,0,0}, 2);
        assert result4 == 2 : "Test 4 failed: expected 2, got " + result4;
        System.out.println("Test 4 passed: " + result4);

        // Test case 5: All ones
        int result5 = longestOnes(new int[]{1,1,1,1}, 0);
        assert result5 == 4 : "Test 5 failed: expected 4, got " + result5;
        System.out.println("Test 5 passed: " + result5);

        System.out.println("\n✓ All tests passed!");
    }
}