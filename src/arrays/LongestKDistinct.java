package arrays;

public class LongestKDistinct {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

//        abcba 2

        int[] freq = new int[26];
        int distinctCount = 0;
        int longest = 0;
        int left = 0, right = 0;
        while(right < s.length()){
            if(freq[s.charAt(right) - 'a'] == 0){
                distinctCount++;
            }
            freq[s.charAt(right)-'a']++;

            right++;

            while(distinctCount > k){
                freq[s.charAt(left) - 'a']--;
                if(freq[s.charAt(left) - 'a']==0) {
                    distinctCount--;
                }
                left++;
            }

            longest = Math.max(longest, right-left+1);
        }

        return longest;

    }

    public static void main(String[] args) {
        // Test case 1
        int result1 = lengthOfLongestSubstringKDistinct("eceba", 2);
        assert result1 == 3 : "Test 1 failed: expected 3, got " + result1;
        System.out.println("Test 1 passed: " + result1);

        // Test case 2
        int result2 = lengthOfLongestSubstringKDistinct("aa", 1);
        assert result2 == 2 : "Test 2 failed: expected 2, got " + result2;
        System.out.println("Test 2 passed: " + result2);

        // Test case 3
        int result3 = lengthOfLongestSubstringKDistinct("abcba", 2);
        assert result3 == 3 : "Test 3 failed: expected 3, got " + result3;
        System.out.println("Test 3 passed: " + result3);

        System.out.println("\nAll tests passed! ✓");
    }
}