import java.util.HashMap;
import java.util.HashSet;

public class HashingProblem {

    public static void majorityElement(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 3) {
                System.out.print(key + " ");
            }
        }
        System.out.println();
    }

    public static void UnionOfArray(int arr1[] , int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        for(int no : arr1){
            set.add(no);
        }
        for(int no : arr2){
            set.add(no);
        }

        System.out.println("Size of union of array : " + set.size());
        for(int no : set){
            System.out.print(no + " ");
        }
        System.out.println();
    }

    public static void IntersectionOfArray(int arr1[] , int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        for(int no : arr1){
            set.add(no);
        }

        int count = 0;
        for(int no : arr2){
            if(set.contains(no)){
                count++;
                set.remove(no);
            }
        }
        System.out.println("No Intersection elements of Arrays : " + count);
    }

    public static void ItineraryFromTicket(HashMap<String,String> tick){
        String start = getStart(tick);

        while(tick.containsKey(start)){
            System.out.print(start + "->");
            start = tick.get(start);
        }
        System.out.println(start);
    }
    public static String getStart(HashMap<String,String> tick){
        HashMap<String,String> revMap = new HashMap<>();

        for(String key : tick.keySet()){
            revMap.put(tick.get(key), key);
        }

        for(String key : tick.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }

        return null;
    }


    public static void SubArraySum(int arr[] , int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        //adding base case(empty subarray)   sum -> count
        map.put(0, 1);

        int sum = 0 , count = 0;
        for(int no : arr){
            sum += no;
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1)  ;

            }else{
                map.put(sum, 1);
            }
            if(map.containsKey(sum - k)){
                count += map.get(sum-k);
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        // int nums[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        int nums[] = {1,2};

        majorityElement(nums);


        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        UnionOfArray(arr1, arr2);
        IntersectionOfArray(arr1, arr2);



        HashMap<String,String> tickets = new HashMap<>();

        tickets.put("Chennai", "Bengluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        ItineraryFromTicket(tickets);


        int arr[] = {10,2,-2,-20,10};
        SubArraySum(arr, 10);
    }
}
