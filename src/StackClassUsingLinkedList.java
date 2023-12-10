// ******   FUNCTION CAN BE STATIC OR NOT   *******

public class StackClassUsingLinkedList {
    private static class Node{
        int data;
        Node next ;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        public static Node Head;

        public boolean isEmpty(){
            return Head == null;
        }

        public void push(int data){
            Node newNode = new Node(data);

            if(isEmpty()){
                Head = newNode;
            return ;
            }

            newNode.next = Head;
            Head = newNode; 
        }

        public int pop(){
            if(isEmpty()){
                return -1;
            }

            int top = Head.data;
            Head = Head.next; 
            return top;
        }
        
        public int peek(){
            if(isEmpty()){
                return -1;
            } 
            return Head.data;

        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
