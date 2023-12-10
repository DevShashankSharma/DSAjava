import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hash_Map {
    public static void main(String[] args) {
        // country,population
        HashMap<String,Integer> map = new HashMap<>();

        map.put("India", 130);
        map.put("USA", 50);
        map.put("China", 150);

        System.out.println(map); // print in unordered way s//y as hashSet

        //If key already exist it update the  value
        map.put("China", 180);
        System.out.println(map);

        //Search 
        if(map.containsKey("Indonesia")){
            System.out.println("Key is persent in map");
        }
        else{
            System.out.println("Key is not persent in map");
        }


        System.out.println(map.get("India"));   // Key exists
        System.out.println(map.get("Indonesia"));  // Key not exists


        // Iterator 
        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.println(e.getKey() + " = " + e.getValue());
        }

        Set<String> keys = map.keySet(); 
        for(String key : keys){
            System.out.println(key + ":" + map.get(key));
        }

        map.remove("China");
        System.out.println(map);
    }
}
