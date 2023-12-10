public class LinkedListsReverse {
    Node Head;
    private int size;

    LinkedListsReverse() {
        this.size = 0;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (Head == null) {
            Head = newNode;
            return;
        }

        Node currNode = Head;

        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    public void print() {
        if (Head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = Head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    // using iterative 
    public void reverse() {
        if (Head == null || Head.next == null) {
            return;
        }

        Node preNode = Head;
        Node currNode = preNode.next;
          

        while (currNode != null) {
            Node nexNode = currNode.next;
            currNode.next = preNode;

            // update 
            preNode = currNode;
            currNode = nexNode;
        }
        Head.next = null;
        Head = preNode;

    }

    // using recursive
    public Node reverseRecursive(Node Head){
        if(Head == null || Head.next == null){
            return Head;
        }

        Node newHead = reverseRecursive(Head.next);
        Head.next.next = Head;
        Head.next = null;

        return newHead ;
    }

    // *********** PHADU CONCEPT *************
    public Node reverseBetween(Node head, int m, int n) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        Node nodeA = pre.next;
        Node nodeB = nodeA.next;
        for (int i = 0; i < (n - m); i++) {
            nodeA.next = nodeB.next;
            nodeB.next = pre.next;
            pre.next = nodeB;
            nodeB = nodeA.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        LinkedListsReverse list = new LinkedListsReverse();

        int arr[] = { 22, 33, 45, 12, 9, 50, 19, 25 };

        for (int no : arr) {
            list.add(no);
        }

        list.print();

        list.reverse();
        list.print();

        list.Head = list.reverseRecursive(list.Head);
        list.print();
    }
}
