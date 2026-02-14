package arrays;

import java.util.*;

public class FindAnagrams {

    public static List<Integer> findAnagrams(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        if(text.length() < pattern.length()){
            return new ArrayList<>();
        }

        int[] patternFreq = new int[26];
        for(char c : pattern.toCharArray()){
            patternFreq[c - 'a']++;
        }

        int[] windowFreq = new int[26];
        int windowSize = pattern.length();

        for(int i = 0; i < windowSize; i++){
            windowFreq[text.charAt(i) - 'a']++;
        }

        if(matches(patternFreq, windowFreq)){
            result.add(0);
        }

        for(int right = windowSize; right < text.length(); right++){
            windowFreq[text.charAt(right) - 'a']++;
            int left = right - windowSize;
            windowFreq[text.charAt(left) - 'a']--;

            if(matches(patternFreq, windowFreq)){
                result.add(left+1);
            }
        }

        return result;
    }

    public static boolean matches(int[] patternFreq, int[] windowFreq){
        for(int i = 0; i < windowFreq.length; i++){
            if(patternFreq[i] != windowFreq[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test case 1
        List<Integer> result1 = findAnagrams("cbaebabacd", "abc");
        System.out.println("Test 1: " + result1);
        assert result1.equals(Arrays.asList(0, 6)) : "Test 1 failed";

        // Test case 2
        List<Integer> result2 = findAnagrams("abab", "ab");
        System.out.println("Test 2: " + result2);
        assert result2.equals(Arrays.asList(0, 1, 2)) : "Test 2 failed";

        // Test case 3
        List<Integer> result3 = findAnagrams("baa", "aa");
        System.out.println("Test 3: " + result3);
        assert result3.equals(Arrays.asList(1)) : "Test 3 failed";

        System.out.println("\nAll tests passed! ✓");
    }
}