package arrays;

public class RangeSumQuery {

    private int[] prefix;

    // Constructor: build prefix sum once
    public RangeSumQuery(int[] arr) {
        this.prefix = new int[arr.length];
        this.prefix[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            this.prefix[i] = this.prefix[i-1] + arr[i];
        }
    }

    // Query: return sum from index left to right (inclusive)
    public int rangeSum(int left, int right) {
        if(left == 0){
            return prefix[right];
        }
        return prefix[right] - prefix[left-1];
    }

    // Test cases
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 5};
//        3 4 8 10 15
        RangeSumQuery rsq = new RangeSumQuery(arr);

        // Test 1: Sum from index 1 to 3 → [1, 4, 2] = 7
        System.out.println("Sum(1, 3) = " + rsq.rangeSum(1, 3));
        System.out.println("Expected: 7");
        System.out.println();

        // Test 2: Sum from index 0 to 4 → [3, 1, 4, 2, 5] = 15
        System.out.println("Sum(0, 4) = " + rsq.rangeSum(0, 4));
        System.out.println("Expected: 15");
        System.out.println();

        // Test 3: Sum from index 2 to 4 → [4, 2, 5] = 11
        System.out.println("Sum(2, 4) = " + rsq.rangeSum(2, 4));
        System.out.println("Expected: 11");
    }
}
