package arrays;

import java.util.*;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        // Your code here

        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }

            right++;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {0,1,0,3,12};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1)); // [1,3,12,0,0]

        int[] nums2 = {0};
        moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2)); // [0]
    }
}