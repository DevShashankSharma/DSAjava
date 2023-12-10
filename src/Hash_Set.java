import java.util.HashSet;
import java.util.Iterator; 

public class Hash_Set {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        // add element ---------> add only different element as property of a set
        set.add(3);
        set.add(6);
        set.add(4);
        set.add(3);

        System.out.println(set.size());
        System.out.println(set);

        // Search
        if (set.contains(6)) {
            System.out.println("present");
        }

        if (!set.contains(5)) {
            System.out.println("absent");
        }

        // Delete
        set.remove(1);
        if (!set.contains(1)) {
            System.out.println("absent");
        }

        //Iterator  -----> element can be print in any order  
        // Iterator it = set.iterator();
        Iterator<Integer> it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        //isEmpty
       if(!set.isEmpty()) {
        System.out.println("set is not empty");
       }
    }
}