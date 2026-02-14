package arrays;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        // Your code here

        if(s.length() < t.length()) return "";

        HashMap<Character, Integer> targetFreq = new HashMap<>();
        HashMap<Character, Integer> windowFreq = new HashMap<>();

        for(char c : t.toCharArray()){
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        int requiredSize = targetFreq.size();
        int formedSize = 0;
        int newStart = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int left = 0, right = 0;

        while(right < s.length()){
            windowFreq.put(s.charAt(right), windowFreq.getOrDefault(s.charAt(right), 0) + 1);

            if(targetFreq.containsKey(s.charAt(right)) && windowFreq.get(s.charAt(right)).equals(targetFreq.get(s.charAt(right)))){
                formedSize++;
            }

//            require min window so shrink when all conditions satisfy.
            while(formedSize == requiredSize){

//                valid window before shrinking
                if(right - left + 1 < minWindowLength){
                    minWindowLength = right - left + 1;
                    newStart = left;
                }

                char leftChar = s.charAt(left);

                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if(targetFreq.containsKey(leftChar) && windowFreq.get(leftChar) < targetFreq.get(leftChar)){
                    formedSize--;
                }

                left++;
            }

            right++;
        }


        return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(newStart, newStart+minWindowLength);
    }

    public static void main(String[] args) {
        // Test case 1
        String result1 = minWindow("ADOBECODEBANC", "ABC");
        if (!result1.equals("BANC")) {
            System.out.println("❌ Test 1 failed: expected BANC, got " + result1);
            return;
        }
        System.out.println("✓ Test 1 passed: " + result1);

        // Test case 2
        String result2 = minWindow("a", "a");
        if (!result2.equals("a")) {
            System.out.println("❌ Test 2 failed: expected a, got " + result2);
            return;
        }
        System.out.println("✓ Test 2 passed: " + result2);

        // Test case 3
        String result3 = minWindow("a", "aa");
        if (!result3.equals("")) {
            System.out.println("❌ Test 3 failed: expected empty string, got " + result3);
            return;
        }
        System.out.println("✓ Test 3 passed: " + result3);

        // Test case 4
        String result4 = minWindow("a", "b");
        if (!result4.equals("")) {
            System.out.println("❌ Test 4 failed: expected empty string, got " + result4);
            return;
        }
        System.out.println("✓ Test 4 passed: " + result4);

        System.out.println("\n🎉 All tests passed!");
    }
}