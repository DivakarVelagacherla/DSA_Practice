package arrays;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        // Your code here

        return "";
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