package arrays;

public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        // Your code here
        int left = 0, right = numbers.length-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum < target){
                left++;
            }else{
                right--;
            }

            if(sum==target){
                return new int[]{left+1, right+1};
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        // Test case 1
        int[] result1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");
        // Expected: [1, 2] (1-indexed)

        // Test case 2
        int[] result2 = twoSum(new int[]{2, 3, 4}, 6);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");
        // Expected: [1, 3]

        // Test case 3
        int[] result3 = twoSum(new int[]{-1, 0}, -1);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");
        // Expected: [1, 2]
    }
}