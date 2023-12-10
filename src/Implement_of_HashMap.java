import java.util.ArrayList;
import java.util.LinkedList;

public class Implement_of_HashMap {
    static class HashMap<K,V>{
        private class Node {
            K key;
            V value;

            Node(K key , V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n;  // n ---> no. of keys
        private int N;  // N ---> no. of buckets
    
        private LinkedList<Node> buckets[]; 

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0 ; i<4 ; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }
        
        private int hashfunction(K key){
            int bi = key.hashCode();  // value return can be -ve or +ve  and can be 123456789
            // to make -ve  to +ve use func abs() and to get index from 0 to N divide by N
            return Math.abs(bi)%N;
        }

        private int SearchInLL(K key , int bi){
            LinkedList<Node> ll = buckets[bi];

            for(int i=0 ; i<ll.size() ; i++){
                if(ll.get(i).key == key){
                    return i;
                }
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void reHash(){
            LinkedList<Node> oldBucket[] = buckets;
            N = N*2;
            buckets = new LinkedList[N];

            for(int i=0 ; i<N ; i++){
                buckets[i] = new LinkedList<>();    
            }

            for(int i=0 ; i<oldBucket.length ; i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0 ; j<ll.size() ; j++){
                    Node newNode = ll.get(j);
                    put(newNode.key, newNode.value);
                }
            }
        }
        public void put(K key , V value){
            int bi = hashfunction(key);
            int di = SearchInLL(key,bi);

            if(di == -1){    // key doesn't exists
                buckets[bi].add(new Node(key,value));
                n++;
            }
            else{       // key exists
                Node newNode = buckets[bi].get(di);
                newNode.value = value ; 
            }

            double lambda = (double)n/N ; 
            if(lambda > 2.0){
                // rehashing 
                reHash();
            }
        }

        public V get(K key){
            int bi = hashfunction(key);
            int di = SearchInLL(key,bi);

            if(di == -1){    // key doesn't exists
                return null;
            }
            else{       // key exists
                Node newNode = buckets[bi].get(di);
                return newNode.value ; 
            }
        }

        public boolean containsKey(K key){
            int bi = hashfunction(key);
            int di = SearchInLL(key,bi);

            if(di == -1){    // key doesn't exists
                return false;
            }
            else{       // key exists
                return true; 
            }
        }

        public V remove(K key){
            int bi = hashfunction(key);
            int di = SearchInLL(key,bi);

            if(di == -1){    // key doesn't exists
                return null;
            }
            else{       // key exists
                 Node newNode = buckets[bi].remove(di);
                 n--;
                 return newNode.value;

            }
        }

        public boolean isEmpty(){
            return n==0 ;
        }

        public ArrayList<K> keysets() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0 ; i<buckets.length ; i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0 ; j<ll.size() ; j++){
                    Node newNode = ll.get(j);
                    keys.add(newNode.key);
                }
            }

            return keys;
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("China", 150);
        map.put("USA",50);

        System.out.println(map.get("China")); 

        ArrayList<String> keys = map.keysets();
        for(int i=0 ; i<keys.size() ; i++){
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
        }

        map.remove("India");
        System.out.println(map.get("India"));
    }
}
