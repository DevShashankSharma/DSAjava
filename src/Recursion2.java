import java.util.HashSet;

public class Recursion2 {
    // Time complexity = O(2^n -1) ~ O(2^n)
    public static void TowerOfHanoi(int n , String src , String help , String dest){
        if(n==1){
            System.out.println("Transfer disk "+n+" from "+src +" to "+dest);
            return;
        }
        TowerOfHanoi(n-1, src, dest, help);
        System.out.println("Transfer disk "+n+" from "+src +" to "+dest);
        TowerOfHanoi(n-1, help, src, dest);
    }

    // Time complexity = O(n)
    public static void ReverseString(int idx , String str){
        if(idx == 0){
            System.out.println(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx));
        ReverseString(idx-1, str);
    }

    // Time complexity = O(n) 
    public static int first=-1,last=-1;
    public static void PrintFirstLastOccur(String str , char element , int idx ){
        if(idx == str.length()){
            System.out.println("First occurence index : " + first);
            System.out.println("Last occurence index : " + last);
            return;
        }
        if(str.charAt(idx) == element){
            if(first==-1){
                first = idx;
            } else {
                last = idx;
            }
        }
        PrintFirstLastOccur(str, element, idx+1);
    }

    // Time complexity = O(n+count) : max(count)=n : O(2n) : removing constant : O(n)
    public static void MoveX(String str , int idx , int count , String newStr){
        if(idx == str.length()){
            for(int i=0 ; i<count ; i++){
                newStr += "x";
            }
            System.out.println(newStr);
            return;
        }
        if(str.charAt(idx) == 'x'){
            MoveX(str, idx+1, count+1, newStr);
        } else{
            newStr += str.charAt(idx);
            MoveX(str, idx+1, count, newStr);
        }
    }

    // time complexity = O(n) 
    public static boolean []map = new boolean[26];
    public static void RemoveDuplicate(String str , int idx , String newStr){
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true){
            RemoveDuplicate(str, idx+1, newStr);
        } else{
            newStr += currChar;
            map[currChar - 'a'] = true ;
            RemoveDuplicate(str, idx+1, newStr);
        }
    }

    // Time complexity = O(2^n) 
    public static void Subsequences(String str , int idx , String newStr , HashSet<String> set){
        if(idx == str.length()){
            if(set.contains(newStr)){
                return;
            }else{
                set.add(newStr);
                // System.out.println(newStr);
                System.err.println(newStr);
                return;
            }
        }
        char currChar = str.charAt(idx);
        //to be 
        Subsequences(str, idx+1, newStr+currChar , set);
        // not to be 
        Subsequences(str, idx+1, newStr , set);
    }

    // Time complexity = O(4^n)
    public static String[] keypad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void PrintCombination(String str , int idx , String combination){
        if(idx == str.length()){
            System.out.println(combination);
            return;
        }
        char currChar = str.charAt(idx);
        String map = keypad[currChar - '0'];
        for(int i=0 ; i<map.length() ; i++){
            PrintCombination(str, idx+1, combination+map.charAt(i));
        }
    }
    public static void main(String[] args) {
        // int n=4;
        // TowerOfHanoi(n, "S", "H", "D");

        // String str = "abcd";
        // ReverseString(str.length()-1, str);

        // String str = "abaacdaefaah";
        // PrintFirstLastOccur(str, 'a', 0);

        // String str = "axbcxxd";
        // MoveX(str, 0, 0, "");

        // String str = "abbccda";
        // RemoveDuplicate(str, 0, "");

        // String str = "abc";
        // HashSet<String> set = new HashSet<>();
        // String str = "aaa";
        // Subsequences(str, 0, "" , set);

        String str= "23"; 
        PrintCombination(str, 0, "");
    }
}
