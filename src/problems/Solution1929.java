package problems;

/*
Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and
ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.
 */

public class Solution1929 {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        // uno inicia en la primera posicion del arreglo
        // el segundo justo donde ya no hay elementos del arrelo original
        int l = 0, r = len;
        int[] ans = new int[len*2];
        while(l < len) {
            // El mismo valor para las dos posiciones de los punteros
            // dado que es la concatenacion de nums+nums
            ans[l] = nums[l];
            ans[r] = nums[l];
            l++;
            r++;
        }

        return ans;
    }
}
