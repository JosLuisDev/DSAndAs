package problems;

class Node {
    int value;
    Node next;
    Node prev;

    Node(int value) {
        this.value = value;
    }
}

class MyLinkedList {

    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        this.size = 0;
        this.head = null; // Inicializar head y tail a null
        this.tail = null;
    }

    public int get(int index) {
        if (index >= this.size || index < 0) {
            return -1;
        }

        Node current;
        // Optimización de búsqueda: desde head o tail
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.value;
    }

    public void addAtHead(int val) {
        Node newNode =  new Node(val);
        if(this.size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        this.size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(this.size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        // Si el index no es valido no hacer nada
        if(index > this.size || index < 0) return;

        if(index == this.size) {
            this.addAtTail(val);
        } else if(index == 0) {
            this.addAtHead(val);
        } else {
            Node newNode = new Node(val);
            Node current;

            if(index < size / 2) { // Buscar desde head
                current = head;
                for (int i = 0; i < index; i++) { // Cuando i == index el target ya estara en current
                    current = current.next;
                }
            } else { // buscar desde tail
                current = tail;
                for (int i = size - 1; i > index; i--) { // El bucle debe ir hasta el índice actual
                    current = current.prev;
                }
            }

            // 'current' es el nodo que estará DESPUÉS de newNode
            Node prevNode = current.prev;
            newNode.next = current;
            newNode.prev = prevNode;
            // Conectar los nodos adyacentes al nuevo nodo
            if(prevNode != null) { // Asegurarse de que prevNode no es null (caso addAtHead)
                prevNode.next = newNode;
            }
            current.prev = newNode;

            this.size++;
        }

    }

    public void deleteAtIndex(int index) {

        if(index >= size || index < 0) {
            return;
        }

        // index == 0 significa que eliminamos el head
        Node target;
        if(index == 0) {
            head = head.next; // Si es null no importa
            if(head != null) { // Si la lista no se vacio despues de la eliminacion
                head.prev = null; // Quitamos la referencia que tenia el actual head con el anterior head
            } else { // Si se vacio
                tail = null; // Quitamos la referencia de tail que apuntaba al head tambien
            }
        } else if(index == size - 1) { // Eliminar de la cola
            tail = tail.prev; // Pasamos el puntero al nodo anterior
            if(tail != null) { // Si no se vacio
                tail.next = null; // Quitamos la referencia del actual tail al anterior tail
            } else { // Si se vacio
                head = null; // Debemos eliminar la referencia de head
            }
        } else { // Eliminar de en medio
            // Validar como vamos a buscar el elemento a eliminar
            if(index < size / 2) {
                target = head;
                for(int i=0; i < index; i++) {
                    target = target.next;
                }
            } else {
                target = tail;
                for(int i= size-1; i > index; i--) {
                    target = target.prev;
                }
            }

            // Eliminar target
            target.next.prev = target.prev;
            target.prev.next = target.next;
            // Desvincularlo para que el GC lo recoja
            target.prev = null;
            target.next = null;
        }
        this.size--;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
