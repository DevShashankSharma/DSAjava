import java.util.ArrayList;
import java.util.Collections;

class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // ArrayList<String> list1 = new ArrayList<String>(); // we can write String or not 
        // ArrayList<Boolean> list3 = new ArrayList<>();

        // Add elements
        list.add(2);
        list.add(4);
        list.add(1);

        System.out.println(list);

        // Get elements
        int element = list.get(0);
        System.out.println(element);

        // Set elements in between
        list.add(1,6);
        System.out.println(list);

        //Replace(set) element
        list.set(0, 3);
        System.out.println(list);

        // Delete element
        list.remove(2);
        System.out.println(list);

        // Size of list
        int size = list.size();
        System.out.println(size);

        // Loop
        for(int i=0 ; i<list.size() ; i++){
            System.out.println(list.get(i));
        }

        //Sorting
        Collections.sort(list);
        System.out.println(list);
    }
}
