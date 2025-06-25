package problems;

class BrowserNode {
    String url;
    BrowserNode next;
    BrowserNode prev;

    public BrowserNode(String url) {
        this.url = url;
    }
}

class Solution1472 {

    BrowserNode head;
    BrowserNode tail;
    BrowserNode curr;

    public Solution1472(String homepage) {
        head = new BrowserNode(homepage);
        tail = head;
        curr = head;
    }

    public void visit(String url) {
        System.out.println("Visit start curr: " + curr.url);
        BrowserNode bn = new BrowserNode(url);
        if (curr == head) { // Si estamos en el homepage (primer nodo)
            curr = bn;
            head.next = bn;
            bn.prev = head;
            tail = bn;
        } else if(curr == tail) { // Anadir al final
            tail.next = bn;
            bn.prev = tail;
            tail = bn;
            curr = bn;
        } else { // Anadir en medio
            // El current se debe enlazara con el nuevo nodo y este nuevo nodo se convertira en el nuevo tail
            curr.next = bn;
            bn.prev = curr;
            curr = bn;
            tail = bn;
        }


    }

    public String back(int steps) {

        // Validar si estamos en el head no podemos regresar mas
        if(curr == head) {

            return curr.url;
        } else { // Si no estamos en el homepage podemos regresar n veces hasta el homepage (head)
            int count = 0;

            while(curr != head && count < steps) {
                count++;
                curr = curr.prev;
                System.out.print(curr.url);
            }

            return curr.url;
        }
    }

    public String forward(int steps) {

        if(curr == tail) {
            return curr.url;
        } else {
            int count = 0;
            while(curr != tail && count < steps) {
                count++;
                curr = curr.next;
            }

            return curr.url;
        }
    }
}

/**
 * Your Solution1472=BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */