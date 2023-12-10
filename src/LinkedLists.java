class LinkedLists {
    Node head;
    private int size;

    LinkedLists(){
        this.size = 0;
    }

    class Node {
        String data;
        Node Next;

        Node(String data) {
            this.data = data;
            Next = null;
            size++;
        }
    }

    // add - first
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.Next = head;
        head = newNode;
    }

    // add - last
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.Next != null) {
            currNode = currNode.Next;
        }

        currNode.Next = newNode;
    }

    // print
    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.Next;
        }
        System.out.println("Null");
    }

    // delete - first
    public void deleteFirst() {
        if (head == null) {
            System.out.println("This is empty list");
            return;
        }
        size--;

        head = head.Next;
    }

    // delete - last
    public void deleteLast(){
        if(head == null){
            System.out.println("this is empty list");
            return;
        }

        size--;
        if (head.Next == null){
            head = null;
            return;
        }

        Node secondlastNode = head;
        Node lastNode = head.Next;
        while(lastNode.Next != null){
            lastNode = lastNode.Next;
            secondlastNode = secondlastNode.Next;
        }  
        secondlastNode.Next = null;      
    }

    public int getsize(){
        return size;
    }

    public static void main(String[] args) {
        LinkedLists list = new LinkedLists();

        list.print();

        list.addFirst("a");
        list.addFirst("is");
        list.print();

        list.addLast("list");
        list.print();

        list.addFirst("This");
        list.print();

        list.deleteFirst();
        list.print();

        list.deleteLast();
        list.print();
        
        System.out.println(list.getsize());
    }
}
