import java.util.HashSet;
import java.util.Stack;

class Test{
    public static HashSet<Integer> paths = new HashSet<>();
    public static void main(String[] args) {
        paths.add(3);
        System.out.println(paths);

        Stack<Character> stack = new Stack<>();
        String s = "()[]{}";
        for(char ch : s.toCharArray()){
            if(stack.empty()){
                stack.push(ch);
                System.out.println("Empty : " + stack.peek());
            }
            else if(stack.peek() == '(' && ch == ')'){
                char cha = stack.pop();
                System.out.println("()" + cha);
            }
            else if(stack.peek() == '[' && ch == ']'){
                char cha = stack.pop();
                System.out.println("[]" + cha);
            }
            else if(stack.peek() == '{' && ch == '}'){
                char cha = stack.pop();
                System.out.println("{}" + cha);            
            }
            else{
                stack.push(ch);
            }
        }

        if(stack.empty()){
            System.out.println("true");
        }
        else{
            System.out.println(false);
        }
    }
}