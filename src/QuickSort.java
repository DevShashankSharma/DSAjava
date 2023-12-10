public class QuickSort {

    public static int partition(int arr[] , int low , int high) {
        int pivot = arr[high];
        int i = low-1;

        for (int j=low ; j<high ; j++) {
            if(arr[j]<pivot){
                i++;

                // swap 
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        arr[high] = arr[i];
        arr[i] = pivot;

        return i; // pivot_idx
    }

    public static void quickSort(int arr[] , int low , int high){
        if(low < high){
            int pivot_idx = partition(arr,low,high);

            quickSort(arr, low, pivot_idx - 1);
            quickSort(arr, pivot_idx+1, high);
        }
    } 
    public static void main(String[] args) {
        int arr[] = {6,3,5,9,2,8};
        int n = arr.length;

        quickSort(arr, 0, n-1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
