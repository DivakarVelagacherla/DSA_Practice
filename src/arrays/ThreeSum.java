package arrays;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] arr) {
        // Your code here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
//        -4 -1 -1 0 1 2
        for(int i = 0; i < arr.length-2; i++){

            if(i > 0 && arr[i] == arr[i-1]){
                continue;
            }

            int left = i+1;
            int right = arr.length-1;
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0){
                    result.add(List.of(arr[i], arr[left], arr[right]));
                }

                while(left < right && arr[left] == arr[left-1]){
                    left++;
                }

                while(left < right && arr[right-1] == arr[right]){
                    right--;
                }

                if(sum < 0){
                    left++;
                }else {
                    right++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        List<List<Integer>> result1 = threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println("Test 1: " + result1);

        // Test case 2
        List<List<Integer>> result2 = threeSum(new int[]{0,1,1});
        System.out.println("Test 2: " + result2);

        // Test case 3
        List<List<Integer>> result3 = threeSum(new int[]{0,0,0});
        System.out.println("Test 3: " + result3);
    }
}