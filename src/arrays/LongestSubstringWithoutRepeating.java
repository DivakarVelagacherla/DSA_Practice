package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        /*
        need longest substring without repeating chars. so freq doesnt matter. So I can safely use set?? yes because
        my window becomes in valid if i have one repeating char.
         */

        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> seen = new HashSet<>();
        while(right < s.length()) {
//            always expand
            char c = s.charAt(right);

            while(seen.contains(c)){
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(c);
            right++;

            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        // Test case 1: Normal case
        int result1 = lengthOfLongestSubstring("abcabcbb");
        assert result1 == 3 : "Test 1 failed: expected 3, got " + result1;
        System.out.println("Test 1 passed: " + result1);

        // Test case 2: All same characters
        int result2 = lengthOfLongestSubstring("bbbbb");
        assert result2 == 1 : "Test 2 failed: expected 1, got " + result2;
        System.out.println("Test 2 passed: " + result2);

        // Test case 3: Mixed
        int result3 = lengthOfLongestSubstring("pwwkew");
        assert result3 == 3 : "Test 3 failed: expected 3, got " + result3;
        System.out.println("Test 3 passed: " + result3);

        // Test case 4: Empty string
        int result4 = lengthOfLongestSubstring("");
        assert result4 == 0 : "Test 4 failed: expected 0, got " + result4;
        System.out.println("Test 4 passed: " + result4);

        // Test case 5: Single character
        int result5 = lengthOfLongestSubstring("a");
        assert result5 == 1 : "Test 5 failed: expected 1, got " + result5;
        System.out.println("Test 5 passed: " + result5);

        // Test case 6: All unique
        int result6 = lengthOfLongestSubstring("abcdef");
        assert result6 == 6 : "Test 6 failed: expected 6, got " + result6;
        System.out.println("Test 6 passed: " + result6);

        // Test case 7: Special characters
        int result7 = lengthOfLongestSubstring("a b c a");
        assert result7 == 3 : "Test 7 failed: expected 3, got " + result7;
        System.out.println("Test 7 passed: " + result7);

        System.out.println("\n✓ All tests passed!");
    }
}