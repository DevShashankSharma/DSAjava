// import java.util.LinkedList;

public class LinkedListsPractiseQuestion {
    Node Head;
    private int size;

    LinkedListsPractiseQuestion() {
        this.size = 0;
    }

    class Node {
        int data;
        Node next;

        Node(int no) {
            this.data = no;
            this.next = null;
            size++;
        }
    }

    public void add(int no) {
        Node newNode = new Node(no);
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

    public int indexof(int no) {
        Node currNode = Head;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (no == currNode.data) {
                index = i;
                break;
            }
            currNode = currNode.next;
        }
        return index;
    }

    // delete - first
    public void deleteFirst() {
        if (Head == null) {
            System.out.println("This is empty list");
            return;
        }
        size--;

        Head = Head.next;
    }

    // delete - last
    public void deleteLast() {
        if (Head == null) {
            System.out.println("this is empty list");
            return;
        }

        size--;
        if (Head.next == null) {
            Head = null;
            return;
        }

        Node secondlastNode = Head;
        Node lastNode = Head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondlastNode = secondlastNode.next;
        }
        secondlastNode.next = null;
    }

    public void delete(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }

        Node currNode = Head.next;
        Node currseclastNode = Head;

        for (int i = 1; i < index; i++) {
            currseclastNode = currseclastNode.next;
            currNode = currNode.next;
        }
        currseclastNode.next = currNode.next;
        size--;
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
        System.out.println("Null");
    }

    public int get(int index) {
        Node currNode = Head;
        if (index == 0) {
            return currNode.data;
        }

        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }

        return currNode.data;
    }

    public Node oddEvenList(Node head) {
        if(head == null){
            return head;
        } 
        Node odd=head;
        Node even=head.next;
        Node startEven=even;
        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=startEven;
        return head;
    }

    public static void main(String[] args) {

        /*
         * //Using Collection framework
         * 
         * LinkedList <Integer> list = new LinkedList<>();
         * 
         * int arr[] = {1, 5, 7, 3 , 8, 2, 3};
         * 
         * for(int no : arr){
         * list.add(no);
         * }
         * 
         * System.out.println(list.indexOf(7));
         */

        LinkedListsPractiseQuestion list = new LinkedListsPractiseQuestion();

        int arr[] = {2,1,3,5,6,4,7};

        for (int no : arr) {
            list.add(no);
        }

        int index = list.indexof(7);

        if (index == -1) {
            System.out.println("Element not exist in list");
        } else {
            System.out.println(index);
        }

        list.print();

        for (int i = 0; i < list.size; i++) {
            if (list.get(i) > 25) {
                list.delete(i);
                i--;
            }
        }

        list.print();

        list.Head = list.oddEvenList(list.Head);
        list.print();
    }
}
