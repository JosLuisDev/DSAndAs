package datastructures.linkedlist;

import java.util.ArrayList;

class LinkedList {

    Node head;
    Node tail;
    int size = 0;


    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int get(int index) {
        if(index >= size || index < 0) return -1;
        // Lo utilizo para regresar su valor una vez encontrado
        Node tmp = head;
        for(int i = 0; i < index; i++) {
            tmp = tmp.next;
        }

        return tmp.value;

    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;

    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        if(tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) return false;

        if(index == 0) {
            head = head.next;
            if(head == null) tail = null; // Si la lista se vacía después de remover la cabeza
        } else { // Remover un nodo que no es la cabeza
            Node current = head;
            for(int i=0; i < index - 1; i++) {
                current = current.next;
            }
            // 'current' es ahora el nodo ANTES del nodo a remover
            current.next = current.next.next;
            // si el nodo removido era tail, actualiza el tail
            if(current.next == null) tail = current;
        }
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {

        ArrayList<Integer> res = new ArrayList<>();
        if (head == null) return res;
        Node tmp = head;
        while(tmp != null){
            res.add(tmp.value);
            tmp = tmp.next;
        }

        return res;

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertHead(1);
        list.insertTail(2);
        list.insertHead(0);
        list.remove(1);
        System.out.println(list.getValues());
    }
}