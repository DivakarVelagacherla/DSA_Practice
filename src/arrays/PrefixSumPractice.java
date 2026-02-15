package arrays;

public class PrefixSumPractice {

    public int[] buildPrefixSum(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        return prefix;
    }

    // Test cases
    public static void main(String[] args) {
        PrefixSumPractice solution = new PrefixSumPractice();

        // Test 1
        int[] arr1 = {3, 1, 4, 2, 5};
        int[] result1 = solution.buildPrefixSum(arr1);
        System.out.print("Input: [3, 1, 4, 2, 5] → Output: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [3, 4, 8, 10, 15]");
        System.out.println();

        // Test 2
        int[] arr2 = {1, 2, 3, 4};
        int[] result2 = solution.buildPrefixSum(arr2);
        System.out.print("Input: [1, 2, 3, 4] → Output: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [1, 3, 6, 10]");
    }
}