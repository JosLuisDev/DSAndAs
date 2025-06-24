package problems;

public class Solution21 {
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        // Head sera cualquiera de los dos que sea menor
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        // Usar el nodo cabeza como el comienzo de la lista y simplemente
        // ir enlazando los siguientes elementos dependiendo cual es el menor
        while(list1 != null && list2 != null) { // Hasta que una de las listas acabe
            if(list1.val <= list2.val) {
                curr.next = list1; // el siguiente curr sera el nodo de list1
                list1 = list1.next; // Ve al sig de la list1
            } else {
                curr.next = list2; // El siguiente de curr sera el nodo de list2
                list2 = list2.next; // Ve al siguiente de la list2
            }
            curr = curr.next; // Movemos el curr al que acabamos de enlazar
        }

        // Al terminar habra alguna lista que no haya terminado de enlazarse
        // debido a que las listas ya estan enlazadas cuando una termina solo tenemos que enlazar
        // el sig elemento de la lista que no termino, es como si le pasaramos todos los nodos
        //restantes de esa lista
        if(list1 == null) {
            curr.next = list2;
        }

        if(list2 == null) {
            curr.next = list1;
        }

        return dummyHead.next; // El head siempre sera el sig a dummyHead

    }

}
