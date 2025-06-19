package problems;
/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed.
Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
The remaining elements of nums are not important as well as the size of nums.
Return k.
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length-1; // dos punteros para pasar los val hasta el final del arreglo
        // Mientras que l no sea mayor a r seguira buscando val
        while(l <= r) {
            // Validamos si el elemento actual en l es igual a val buscado
            if (nums[l] == val) {
                // pasamos el ultimo elemento al valor actual
                nums[l] = nums[r];
                // Y el ultimo elemento entonces sera el val
                nums[r] = val;
                // solo decrementamos el puntero que indica la ultima posicion donde se debe poner el sig val si se encuentra
                r--;
            } else {
                // En caso de que el valor actual l no sea val, seguimos buscando en el array
                l++;
            }
        }
        // Cuando l pase r significa que no hay mas elementos que buscar y l = numero de elementos no iguales a val
        return l;
    }
}
