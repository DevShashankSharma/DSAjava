import java.util.Scanner;

public class Problem2Array {
     
    static void reverse(int arr[] , int start , int end){
         int temp;

         while(start<end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
         }
    }

    static void printArray(int arr[],int n){
        for(int i=0 ; i<n ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        
        int[] arr = new int[n];

        for(int i=0 ;i<n ; i++){
            arr[i] = scan.nextInt();
        }
        scan.close();
      
        reverse(arr, 0, n-1);
        printArray(arr, n);
    }
}
