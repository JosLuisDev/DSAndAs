package datastructures.queue;

public class Queue {
    ListNode left;  // front of Queue front -> [1,2,3]
    ListNode right; // back of Queue [1,2,3] <- back

    public Queue() {
        this.left  = null;
        this.right = null;
    }

    public void enqueue(int val) {
        ListNode newNode = new ListNode(val);
        if (this.right != null) {
            // Queue is not empty
            this.right.next = newNode;
            this.right = this.right.next;
        } else {
            // Queue is empty
            this.left = newNode;
            this.right = newNode;
        }
    }

    public int dequeue() {
        if (this.left == null) {
            // Queue is empty
            return -1;
        }
        int val = this.left.val;
        this.left = this.left.next;
        if (this.left == null) {
            this.right = null;
        }
        return val;
    }

    public void print() {
        ListNode cur = this.left;
        while(cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }

}
