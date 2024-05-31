class LinkedListFinal {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            int currentPosition = 0;

            while (current != null && currentPosition < position - 1) {
                current = current.next;
                currentPosition++;
            }

            if (current != null) {
                newNode.next = current.next;
                current.next = newNode;
            } else {
                System.out.println("Invalid position. Cannot insert at position " + position);
            }
        }
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("Linked list is empty. Cannot delete.");
            return;
        }

        if (position == 1) {
            head = head.next;
            return;
        }

        Node current = head;
        int currentPosition = 1;

        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current != null && current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Invalid position. Cannot delete at position " + position);
        }
    }

    public void deleteAfter(int value) {
        Node current = head;
        Node previous = null;

        // Find the node with the given value
        while (current != null && current.data != value) {
            previous = current;
            current = current.next;
        }

        // Check if the value was not found or there is no node to delete after
        if (current == null || current.next == null) {
            System.out.println("Value not found or no node to delete after the given value.");
            return;
        }

        // Delete the node after the found node
        Node nodeToDelete = current.next;
        current.next = current.next.next;
        nodeToDelete.next = null; // Optional: Free up memory by disconnecting the deleted node
    }

    public boolean search(int value) {
        Node current = head;

        // Search for the value
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static class myStacks {
        private Node top; 

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }

        public int pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty. Cannot pop.");
            }
            int poppedValue = top.data;
            top = top.next;
            return poppedValue;
        }

        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty. Cannot peek.");
            }
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }
    public static void main(String[] args) {
        LinkedListFinal list = new LinkedListFinal();
        list.insertAtPos(10, 0); // Insert 10 at position 0
        list.insertAtPos(20, 1); // Insert 20 at position 1
        list.insertAtPos(30, 2); // Insert 30 at position 2
        list.insertAtPos(40, 3);
        list.insertAtPos(50, 4);
        System.out.print("Linked list after insertions: ");
        list.display();

        list.deleteAtPosition(2); // Delete node at position 2
        System.out.print("Linked list after deletion: ");
        list.display();

        list.deleteAfter(10);
        System.out.print("Linked list after deletion of a node after a given value: ");
        list.display();

        System.out.println("Search for 10: " + list.search(10));
        System.out.println("Search for 30: " + list.search(30));

        myStacks stack = new myStacks();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Peek: " + stack.peek()); // Expected output: 30

        System.out.println("Popped value: " + stack.pop()); // Expected output: 30
        System.out.println("Popped value: " + stack.pop()); // Expected output: 20

        System.out.println("Is stack empty? " + stack.isEmpty()); // Expected output: false
    }
}



