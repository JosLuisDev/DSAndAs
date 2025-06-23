package problems;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> reversedStack = new Stack<>();
        // Iterate and add to stack 'reversedStack'
        // Added the next reference to the next element in the stack
        // return the new head that will be the 1st element of the stack
        ListNode current = head;
        while(current != null) { // The loop pushed all the elements, when current is null the loop breaks
            reversedStack.push(current);
            current = current.next; // Pass to the next element
        }

        // Save the new head node
        ListNode newHead = reversedStack.pop(); // Sacamos el primer elemento (top) del stack
        ListNode curr = newHead; // Usado para construir la lista enlazada.
        while(!reversedStack.isEmpty()) { // Iterar mientras haya más nodos en el stack para enlazar
            curr.next = reversedStack.pop(); // El puntero sera el siguiente elemento que saquemos
            curr = curr.next; // Avanzamos al siguiente nodo que acabamos de linkear
        }

        // Como el bucle se detiene cuando el stack esta vacio, debemos linkear el ultimo nodo a null
        curr.next = null;

        return newHead;
    }
}
