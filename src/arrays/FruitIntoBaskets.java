package arrays;

import java.util.HashMap;

public class FruitIntoBaskets {

    public static int totalFruit(int[] fruits) {
        /*
        Problem:
You have two baskets, each can hold one type of fruit.
Return the maximum number of fruits you can pick from trees in a row.
Translation: Find longest subarray with at most 2 distinct values.
         */
//1,2,3,2,2
        int targetDistinct = 2;
        int distinct = 0;
        HashMap<Integer, Integer> distinctFruits = new HashMap<>();
        int left = 0, right = 0;
        int maxLength = 0;

        while(right < fruits.length){
            distinctFruits.put(fruits[right], distinctFruits.getOrDefault(fruits[right],0)+1);
            if(distinctFruits.get(fruits[right]) == 1){
                distinct++;
            }

            right++;


            while(distinct > targetDistinct) {
                distinctFruits.put(fruits[left], distinctFruits.get(fruits[left]) - 1);
                if (distinctFruits.get(fruits[left]) == 0) {
                    distinctFruits.remove(fruits[left]);
                    distinct--;
                }
                left++;

            }

            maxLength = Math.max(maxLength, right - left);


        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test case 1
        int result1 = totalFruit(new int[]{1,2,1});
        if (result1 != 3) {
            System.out.println("❌ Test 1 failed: expected 3, got " + result1);
            return;
        }
        System.out.println("✓ Test 1 passed: " + result1);

        // Test case 2
        int result2 = totalFruit(new int[]{0,1,2,2});
        if (result2 != 3) {
            System.out.println("❌ Test 2 failed: expected 3, got " + result2);
            return;
        }
        System.out.println("✓ Test 2 passed: " + result2);

        // Test case 3
        int result3 = totalFruit(new int[]{1,2,3,2,2});
        if (result3 != 4) {
            System.out.println("❌ Test 3 failed: expected 4, got " + result3);
            return;
        }
        System.out.println("✓ Test 3 passed: " + result3);

        // Test case 4: All same
        int result4 = totalFruit(new int[]{1,1,1,1});
        if (result4 != 4) {
            System.out.println("❌ Test 4 failed: expected 4, got " + result4);
            return;
        }
        System.out.println("✓ Test 4 passed: " + result4);

        System.out.println("\n🎉 All tests passed!");
    }
}