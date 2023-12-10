import java.util.ArrayList;

public class Recursion3 {
    //Time complexity = O(n!)
    public static void Permutation(String str , String permutation){
        if(str.length() == 0){
            System.out.println(permutation);
            return ;             
        }
        for(int i=0 ; i<str.length() ; i++){
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            Permutation(newStr, permutation+currChar);
        }
    }

    public static int CountPath(int i , int j , int n , int m){
        if(i == n || j == m){
            return 0;
        }
        if(i == n-1 || j == m-1){
            return 1;
        }
        int downPath = CountPath(i+1, j, n, m);
        int leftPath = CountPath(i, j+1, n, m);
        return downPath + leftPath;
    }

    public static int PlaceTile(int n , int m){
        if(n==m){
            return 2;
        }
        if(n<m){
            return 1;
        }
        //Verticle place
        int verticlePlace = PlaceTile(n-m, m);
        //Horizontal place 
        int horizontalPlace = PlaceTile(n-1, m);
        return verticlePlace+horizontalPlace;
    }

    public static int CallGuest(int n){
        if(n <= 1){
            return 1;
        }
        //single 
        int ways1 = CallGuest(n-1);

        //pair
        int ways2 = (n-1)*CallGuest(n-2);

        return ways1+ways2;
    }

    // time complexity = O(2^n)
    public static void printSubset(ArrayList<Integer> subset){
        for(int i=0 ; i<subset.size() ; i++){
            System.out.print(subset.get(i) + " ");
        }
        System.out.println();
        return ;
    }
    public static void FindSubset(int n , ArrayList<Integer> subset){
        if(n == 0){
            printSubset(subset);
            return ;
        }
        // add hoga
        subset.add(n);
        FindSubset(n-1, subset);

        // add nahi hoga
        subset.remove(subset.size()-1);
        FindSubset(n-1, subset);
    }
    public static void main(String[] args) {
        // String str = "abc";
        // Permutation(str, "");

        // int n=3 , m=3;
        // System.out.println(CountPath(0, 0, n, m));

        // int n=4 , m=2;
        // System.out.println(PlaceTile(n, m));

        // int n=4;
        // System.out.println(CallGuest(n));

        int n=3;
        ArrayList<Integer> subset = new ArrayList<>();   
        FindSubset(n, subset);  
    }
}
