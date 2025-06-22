package datastructures.doubleendedenqueue;

class Deque {
    Node head;
    Node tail;

    // Deque() will initialize an empty queue.
    public Deque() {

    }

    // bool isEmpty() will return whether the queue is empty or not.
    public boolean isEmpty() {
        return head == null;
    }

    //void append(int value) will insert value at the end of the queue.
    public void append(int value) {
        Node newNode = new Node(value);
        if(!this.isEmpty()) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            head = newNode;
            tail = newNode;
            head.next = tail;
            tail.prev = head;
        }
    }

    //void appendleft(int val) will insert value at the beginning of the queue.
    public void appendleft(int value) {
        Node newNode = new Node(value);
        if(!this.isEmpty()) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            head = newNode;
            tail = newNode;
            head.next = tail;
            tail.prev = head;
        }
    }

    // int pop() will remove and return the value at the end of the queue. If the queue is empty, return -1.
    public int pop() {
        if(this.isEmpty()) return -1;

        if(head == tail) {
            int val = head.value;
            head = null;
            tail = null;
            return val;
        }

        int val = tail.value;
        tail.prev.next = null;
        tail = tail.prev;
        return val;
    }

    //int popleft() will remove and return the value at the beginning of the queue. If the queue is empty, return -1.
    public int popleft() {
        if(this.isEmpty()) return -1;

        if(head == tail) {
            int val = head.value;
            head = null;
            tail = null;
            return val;
        }

        int val = head.value;
        head.next.prev = null;
        head = head.next;
        return val;
    }
}
