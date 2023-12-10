public class QueueUsingLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LQueue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // Enqueue ---> to add
        public void add(int data) {
            Node newNode = new Node(data);
            if (tail == null) {
                tail = head = newNode;
                return;
            }
            tail.next = newNode;
            tail = tail.next;
        }

        // Dequeue -----> O(1)
        public int remove() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            int front = head.data ;

            if(head == tail){
                tail = null;
            }
            head = head.next; 

            return front;
        }

        // peak
        public int peek() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args) {
        LQueue q = new LQueue();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5); 

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
