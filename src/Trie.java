public class Trie {
    static class Node {
        Node[] children;
        boolean EOW = false;

        public Node() {
            children = new Node[26];
            // for (int i = 0; i < 26; i++) {
            //     children[i] = null;
            // }
        }
    }

    static Node root = new Node();

    // Time complexity = O(L) ---> L = length of the string
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                // to add
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
            if (i == word.length() - 1) {
                curr.EOW = true;
            }
        }
    }

    // Time complexity = O(L) ---> L = length of the string
    public static boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
            if (i == word.length() - 1 && curr.EOW == false) {
                return false;
            }
        }
        return true;
    }

    // Problem 1 ------> Word break
    public static boolean Word_break(String key) {
        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {
            String part1 = key.substring(0, i);
            String part2 = key.substring(i);

            if (search(part1) && Word_break(part2)) {
                return true;
            }
        }
        return false;
    }

    // problem 2 ---------> starts with
    public static boolean startsWith(String prefix) {
        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return true;
    }

    // problem 3 --------> Count Unique subtrings ------> total no of nodes of trie
    // == total no of unique prefix
    public static int CountNodes(Node root) {
        if (root == null) {
            return 1;
        }
        int count = 0;
        Node curr = root;
        for (int i = 0; i < 26; i++) { // 26 --> lowercase character
            if (curr.children[i] != null) {
                count += CountNodes(curr.children[i]);
            }
        }

        return count + 1;
    }

    // Largest word with all prefixes
    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        Node curr = root;
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null && curr.children[i].EOW == true) {
                temp.append((char) (i + 'a'));

                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                longestWord(curr.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        /*
         * String[] words = { "the", "a", "there", "their", "any" };
         * 
         * for (String word : words) {
         * insert(word);
         * }
         * 
         * System.out.println(search("there"));
         * System.out.println(search("thor"));
         * System.out.println(search("an"));
         */

        /*
         * // problem 1
         * String[] words = {"i","like" ,"sam" , "samsung" , "mobile"} ;
         * // String key = "ilikesamsung";
         * String key = "ilikesung";
         * 
         * for (String word : words) {
         * insert(word);
         * }
         * System.out.println(Word_break(key));
         */

        // // problem 2
        // String[] words = {"apple","app","mango","man","woman"};
        // String prefix = "app";

        // for (String word : words) {
        // insert(word);
        // }

        // System.out.println(startsWith(prefix));
        // System.out.println(startsWith("moon"));

        // // problem 3
        // // String str = "ababa" ;
        // String str = "apple" ;

        // for(int i=0 ; i< str.length() ; i++){
        // insert(str.substring(i)); // -------> insert of all possible suffix
        // }

        // System.out.println(CountNodes(root));

        // problem 4
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };

        for (String word : words) {
            insert(word);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
