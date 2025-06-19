package problems;

/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
The remaining elements of nums are not important as well as the size of nums.
Return k.
 */

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        // acts as count and a pointer
        int lp = 1; // 1 because the first element by logic is not a duplicated one
        for(int rp = 1; rp < nums.length; rp++) {
            // lp only increments if the previous element is diferent to the current element
            if(nums[rp - 1] != nums[rp]) {
                // Swap the value to the lp pointer position that is a duplicated one
                nums[lp] = nums[rp];
                lp++;
            }
        }

        return lp;
    }

    private void printArray(int[] nums, int len) {
        for(int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test1 = {0,0,1,1,1,2,2,3,3,4};
        int[] test2 = {1,1,2};
        Solution26 sol = new Solution26();
        sol.printArray(test1, sol.removeDuplicates(test1));
        sol.printArray(test2, sol.removeDuplicates(test2));
    }
}
