package sortalgorithms;

import java.util.ArrayList;
import java.util.List;

/*
Implement Insertion Sort and return intermediate states.

Insertion Sort is a simple sorting algorithm that builds the sorted list one element at a time, from left to right.
It works by repeatedly taking an element from the unsorted portion and inserting it into its correct position in the sorted portion of the list.

Objective:

Given a list of key-value pairs, sort the list by key using Insertion Sort. Return a list of lists showing the state of the array after each insertion.
If two key-value pairs have the same key, maintain their relative order in the sorted list.
 */

class Pair {
     int key;
     String value;

     Pair(int key, String value) {
         this.key = key;
         this.value = value;
     }
 }

public class InsertionSort {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> res = new ArrayList<>();
        // Como quieren en la nueva list el input, por eso es desde el 0, el while no entrara en la primera iteracion 0
        for(int i = 0; i < pairs.size(); i++) {
            int j = i -1;

            while(j >=0 && pairs.get(j).key > pairs.get(j+1).key ) {
                Pair temp = pairs.get(j+1);
                pairs.set(j+1, pairs.get(j));
                pairs.set(j, temp);
                j--;
            }

            // Copia el nuevo sub arreglo y metelo en la lista res
            List<Pair> cloneList = new ArrayList<>(pairs);
            res.add(cloneList);
        }

        return res;
    }
}
