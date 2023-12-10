import java.util.HashSet;

public class Problem4Array{
    public static boolean containDuplicate(int arr[]){
        if(arr == null || arr.length == 0){
            return false;
        }
        HashSet <Integer> set = new HashSet<>();

        for(int i : arr){
            if(set.contains(i)){
                return false;
            }
            set.add(i);
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,1,3,3,4,3,2,4,2};

        System.out.println(containDuplicate(arr));
    }
}