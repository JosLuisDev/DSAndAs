package problems;

public class Solution206Better {
    public ListNode reverseList(ListNode head) { // O(n)
        ListNode curr = head; // PAra recorrer la lista
        ListNode prev = null; // Saber el elemento previo (el ultimo no tendra referencia cuando se revierta)
        ListNode next; // Saber el siguiente elemento
        while(curr!=null){ // Cuando ya no hayan nodos
            next = curr.next; // el siguiente elemento debera tener referencia ahora next pero al anterior
            curr.next=prev; // el siguiente nodo sera el nodo anterior (aqui ocurre la reversion)
            prev = curr; // movemos el puntero al nodo actual para la siguiente iteracion
            curr=next; // Movemos el segundo puntero para la siguiente iteracion
        }
        return prev; // Al final este sera el ultimo elemento de la lista original (el nuevo head de la nueva)
    }
}
