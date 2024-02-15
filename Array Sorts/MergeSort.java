public class MergeSort {
    public static void printArray(int[] array){
        System.out.print("[");

        for(int i = 0; i < array.length - 1; i++){
            System.out.print(array[i] + ", ");
        }

        System.out.println(array[array.length - 1]+ "]");
    }
  
    
    int[] merge(int[] left, int[] right, int arrSize){
        //Count for the left, right and complete index;
        int l = 0, r = 0, count = 0;
        int[] sortedArr = new int[arrSize];

        //Initial loop to add most of the values in the sub arrays
        while(l < left.length && r < right.length && count < arrSize){
            System.out.println("Comparing " + left[l] + " to " + right[r]);
            
            if(left[l] <= right[r]){
                System.out.println(left[l] + " <= " + right[r]);
                sortedArr[count] = left[l];
                l++;
            }
            else{
                System.out.println(left[l] + " > " + right[r]);
                sortedArr[count] = right[r];
                r++;
            }
            count++;
            printArray(sortedArr);
        }

        //Catches the remaining values that did not get to the sorted array initially
        while(l < left.length && count < arrSize){
            sortedArr[count] = left[l];
            l++;
            count++;
        }

        while(r < right.length && count < arrSize){
            sortedArr[count] = right[r];
            r++;
            count++;
        }
        
        return sortedArr;
    }

    int[] mergeSort(int[] arr, int arrSize){
        System.out.print("Original Array: ");
        printArray(arr);
        System.out.println(" ArrSize: " + arrSize);

        int[] left = new int[(arrSize / 2) + (arrSize % 2)];
        int[] right = new int[(arrSize / 2)];
        int count = 0;

        for(int i = 0; i < arrSize; i++){
            if(i < (arrSize / 2) + (arrSize % 2)){ // Add to left
                left[i] = arr[i];
            }
            else{   //Add to right
                right[count] = arr[i]; 
                count++;
            }
        }

        System.out.print("Left: ");
        printArray(left);
        System.out.print("Right: ");
        printArray(right);
        System.out.println("-----Recursion------");
        if(left.length > 2 || right.length > 2){
            left = mergeSort(left, left.length);
        }
        if(right.length > 2){
            right = mergeSort(right, right.length);
        }

        System.out.print("Merging:   ");
        printArray(left);
        System.out.print("      and: ");
        printArray(right);
        arr = merge(left, right, arrSize);
        System.out.print("Re-Merged Array: ");
        printArray(arr);
        return arr;
    }
}
