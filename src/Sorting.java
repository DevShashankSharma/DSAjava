public class Sorting {
    public static void main(String[] args) {
        int arr[] = {7,8,3,1,2};

        /* 
        // Bubble Sort 
        // Time complexity = O(n^2)
        for(int i=1 ; i<arr.length ; i++){
            for(int j=0 ; j<(arr.length-i) ; j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }*/

        /* 
        //Selection Sort
        // Time complexity = O(n^2)
        for(int i=0 ; i<arr.length-1 ; i++){
            int smallest = i ;
            for(int j= i+1 ; j<arr.length ; j++){
                if(arr[smallest]>arr[j]){
                    smallest = j ;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }*/
        
        // Insertion Sort
        // Time complexity = O(n^2)
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int j = i-1;
            while(j>=0 && curr < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr;
        }

        for (int i : arr) {
            System.out.println(i);           
        }
    }
}
