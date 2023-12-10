import java.util.*;

public class BinaryTreesYT {
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

    static class BinaryTrees {
        static int idx = -1;

        public Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // Pre-Order Traversal ---> time complexity = O(n)
        /*
         * 1. print ROOT
         * 2. print LEFT-NODE
         * 3. print RIGHT-NODE
         */
        public void preOrderTraverse(Node root) {
            if (root == null) {
                // System.out.print("null ");
                return;
            }
            System.out.print(root.data + " ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }

        // In-Order Traversal ---> time complexity = O(n)
        /*
         * 1. print LEFT-NODE
         * 2. print ROOT
         * 3. print RIGHT-NODE
         */
        public void inOrderTraverse(Node root) {
            if (root == null) {
                // System.out.print("null ");
                return;
            }
            inOrderTraverse(root.left);
            System.out.print(root.data + " ");
            inOrderTraverse(root.right);
        }

        // Post-Order Traversal ---> time complexity = O(n)
        /*
         * 1. print LEFT-NODE
         * 2. print RIGHT-NODE
         * 3. print ROOT
         */
        public void postOrderTraverse(Node root) {
            if (root == null) {
                // System.out.print("null ");
                return;
            }
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.data + " ");
        }

        // Level-Order Traversal ---> time complexity = O(n)
        /*
         * 1. print LEVEL-WISE
         */
        public void levelOrderTraverse(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node curr = q.remove();
                if (curr == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }

            }
        }
    }

    // COUNT OF NODES ---> time complexity = O(n)
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    // SUM OF NODES ---> time complexity = O(n)
    public static int sumNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int left_sum = sumNodes(root.left);
        int right_sum = sumNodes(root.right);

        return left_sum + right_sum + root.data;
    }

    // HEIGHT OF NODES ---> time complexity = O(n)
    public static int heightNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int left_height = heightNodes(root.left);
        int right_height = heightNodes(root.right);

        return Math.max(left_height, right_height) + 1;
    }

    // DIAMETER OF A TREE ---> time complexity = O(n^2)
    public static int diameter_tree(Node root) {
        if (root == null) {
            return 0;
        }

        int diam1 = diameter_tree(root.left);
        int diam2 = diameter_tree(root.right);
        int diam3 = heightNodes(root.left) + heightNodes(root.right) + 1;

        return Math.max(diam1, Math.max(diam2, diam3));
    }

    // DIAMETER OF A TREE ---> time complexity = O(n)
    static class treeInfo {
        int diam;
        int height;

        treeInfo(int diam, int height) {
            this.diam = diam;
            this.height = height;
        }
    }

    public static treeInfo diameter_tree2(Node root) {
        if (root == null) {
            return new treeInfo(0, 0);
        }

        treeInfo leftN = diameter_tree2(root.left);
        treeInfo rightN = diameter_tree2(root.right);

        int myheight = Math.max(leftN.height, rightN.height) + 1;

        int diam1 = leftN.diam;
        int diam2 = rightN.diam;
        int diam3 = leftN.height + rightN.height + 1;

        int mydiam = Math.max(diam2, Math.max(diam1, diam3));

        treeInfo myInfo = new treeInfo(mydiam, myheight);

        return myInfo;
    }

    // SUM OF NODES OF Kth LEVEL
    public static int sum_kth_level(Node root, int k) {
        if (k == 1) {
            return root.data;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        int level = 0;
        int sum = 0;

        while (level < k && !queue.isEmpty()) {
            Node curr = queue.remove();
            if (curr == null) {
                level++;
                queue.add(null);
            } else {
                if (level == k - 1) {
                    sum += curr.data;
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        BinaryTrees tree = new BinaryTrees();

        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        Node root = tree.buildTree(nodes);

        tree.preOrderTraverse(root);
        System.out.println();
        tree.inOrderTraverse(root);
        System.out.println();
        tree.postOrderTraverse(root);
        System.out.println();
        tree.levelOrderTraverse(root);

        System.out.println();
        System.out.println(countNodes(root));

        System.out.println(sumNodes(root));
        System.out.println(heightNodes(root));
        System.out.println(diameter_tree(root));
        System.out.println(diameter_tree2(root).diam);

        System.out.println(sum_kth_level(root, 3));

    }
}