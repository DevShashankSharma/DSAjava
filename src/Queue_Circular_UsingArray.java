public class Queue_Circular_UsingArray {
    static class Circular_Queue {
        static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1;

        Circular_Queue(int n) {
            arr = new int[n];
            this.size = n;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return ((rear + 1) % size) == front;
        }

        // Enqueue ---> to add
        public void add(int data) {
            if (isFull()) {
                System.out.println("full Queue");
                return;
            }

            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Dequeue -----> O(1)
        public int remove() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            int result = arr[front];

            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }

        // peak
        public int peek() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {
        Circular_Queue q = new Circular_Queue(5);

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println(q.remove());
        q.add(6);
        System.out.println(q.remove());
        q.add(7);
        System.out.println();
        
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
