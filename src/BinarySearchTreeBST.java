import java.util.ArrayList;

public class BinarySearchTreeBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Insert key ------> time complexity = O(H) -------> H = height
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void InOrder_traverse(Node root) {
        if (root == null) {
            return;
        }
        InOrder_traverse(root.left);
        System.out.print(root.data + " ");
        InOrder_traverse(root.right);
    }

    // Search key ------> time complexity = O(H) -------> H = height;
    public static boolean searchN(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        } else if (root.data > key) {
            return searchN(root.left, key);
        } else {
            return searchN(root.right, key);
        }
    }

    public static Node deleteN(Node root, int val) {
        if (root.data > val) {
            root.left = deleteN(root.left, val);
        } else if (root.data < val) {
            root.right = deleteN(root.right, val);
        } else { // root.data == root.val
                 // case 1 : when both left and right node are not exists
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 : when either left or right exists
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3 : when both left or right node exists
            Node inOrder_Successor = inOrder_Successors(root.right);
            root.data = inOrder_Successor.data;
            root.right = deleteN(root.right, inOrder_Successor.data);
        }
        return root;
    }

    public static Node inOrder_Successors(Node root) {
        /*
         * if(root.left == null){
         * return root;
         * }
         * Node inOrder_Successor = inOrder_Successors(root.left);
         * return inOrder_Successor;
         * OR
         */

        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void print_in_range(Node root , int x , int y){
        if(root == null){
            return;
        }
        if(root.data >= x && root.data <= y){
            print_in_range(root.left,x,y);
            System.out.print(root.data + " ");
            print_in_range(root.right, x, y);
        }
        else if(root.data < x){
            print_in_range(root.right, x, y);
        }
        else{
            print_in_range(root.left, x, y);
        }
    }

    public static void print_root_to_leaf(Node root , ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);

        if(root.left == null && root.right == null){
            System.out.println(path);
        }
        else{
            print_root_to_leaf(root.left, path);
            print_root_to_leaf(root.right, path);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int val : values) {
            root = insert(root, val);
        }

        InOrder_traverse(root);

        System.out.println();
        System.out.println(searchN(root, 3));

        deleteN(root, 5);
        InOrder_traverse(root);

        System.out.println();
        print_in_range(root, 9, 11);
        System.out.println();

        ArrayList<Integer> path = new ArrayList<>();
        print_root_to_leaf(root, path);
     }
}