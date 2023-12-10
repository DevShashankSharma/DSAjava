// Minimum and Maximum element in array

public class Problem1Array {
    static class Pair {
        int max;
        int min;
    }

    static Pair getminmax(int arr[], int n) {
        // when n=1
        Pair minmax = new Pair();
        if (n == 1) {
            minmax.max = arr[0];
            minmax.min = arr[0];
            return minmax;
        }

        minmax.max = arr[0];
        minmax.min = arr[0];

        for (int i = 1; i < n; i++) {
            if (minmax.max < arr[i]) {
                minmax.max = arr[i];
            }
            if (minmax.min > arr[i]) {
                minmax.min = arr[i];
            }
        }

        return minmax;
    }

    public static void main(String[] args){
        int n = 9;
        int  arr[] = {34,2,1,56,33,79,32,97,54};

        Pair Minmax = new Pair();

        Minmax = getminmax(arr, n);

        System.out.println("Maximum element in array is : " + Minmax.max);
        System.out.println("Minimum element in array is : " + Minmax.min);
    }
}


// Amazing concept for this using recursion to decrease time comlexity



// // Java program of above implementation
// public class GFG {
// 	/* Class Pair is used to return two values from
// 	* getMinMax() */
// 	static class Pair {

// 		int min;
// 		int max;
// 	}

// 	static Pair getMinMax(int arr[], int low, int high)
// 	{
// 		Pair minmax = new Pair();
// 		Pair mml = new Pair();
// 		Pair mmr = new Pair();
// 		int mid;

// 		// If there is only one element
// 		if (low == high) {
// 			minmax.max = arr[low];
// 			minmax.min = arr[low];
// 			return minmax;
// 		}

// 		/* If there are two elements */
// 		if (high == low + 1) {
// 			if (arr[low] > arr[high]) {
// 				minmax.max = arr[low];
// 				minmax.min = arr[high];
// 			}
// 			else {
// 				minmax.max = arr[high];
// 				minmax.min = arr[low];
// 			}
// 			return minmax;
// 		}

// 		/* If there are more than 2 elements */
// 		mid = (low + high) / 2;
// 		mml = getMinMax(arr, low, mid);
// 		mmr = getMinMax(arr, mid + 1, high);

// 		/* compare minimums of two parts*/
// 		if (mml.min < mmr.min) {
// 			minmax.min = mml.min;
// 		}
// 		else {
// 			minmax.min = mmr.min;
// 		}

// 		/* compare maximums of two parts*/
// 		if (mml.max > mmr.max) {
// 			minmax.max = mml.max;
// 		}
// 		else {
// 			minmax.max = mmr.max;
// 		}

// 		return minmax;
// 	}

// 	/* Driver program to test above function */
// 	public static void main(String args[])
// 	{
// 		int arr[] = { 1000, 11, 445, 1, 330, 3000 };
// 		int arr_size = 6;
// 		Pair minmax = getMinMax(arr, 0, arr_size - 1);
// 		System.out.printf("\nMinimum element is %d",
// 						minmax.min);
// 		System.out.printf("\nMaximum element is %d",
// 						minmax.max);
// 	}
// }
