package arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] arr) {
        // 0,0,1,1,1,2,2,3,3,4
//        0,1,1,1,1,2,2,3,3,4
//        0,1,2,1,1,2,2,3,3,4
        /*
        Algo:
        one pointer to track the position
        one pointer to find the element
        array is sorted so dup els would be next to each other.

         */

        int left = 0;
        int right = 1;

        while(right < arr.length){
            if(arr[right] == arr[right-1]){
                right++;
            }else{
                left++;
                arr[left] = arr[right];
                right++;
            }
        }


        return left+1;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1,1,2};
        int len1 = removeDuplicates(nums1);
        System.out.println("Test 1 length: " + len1);
        System.out.print("Array: ");
        for(int i = 0; i < len1; i++) System.out.print(nums1[i] + " ");
        System.out.println();

        // Test case 2
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int len2 = removeDuplicates(nums2);
        System.out.println("Test 2 length: " + len2);
        System.out.print("Array: ");
        for(int i = 0; i < len2; i++) System.out.print(nums2[i] + " ");
        System.out.println();
    }
}