public class QuickSort {
    int divide(int[] quickSortArr, int start, int end){
        int pivot = quickSortArr[end];
        int i = start - 1;

        for(int j = start; j < end; j++){
            if(quickSortArr[j] <= pivot){
                i++;

                int swapTemp = quickSortArr[i];
                quickSortArr[i] = quickSortArr[j];
                quickSortArr[j] = swapTemp;
            }
        }

        int swapTemp = quickSortArr[i+1];
        quickSortArr[i+1] = quickSortArr[end];
        quickSortArr[end] = swapTemp;
        return i+1;
    }

    int[] quickSort(int[] quickSortArr, int start, int end){
        if(start < end){
            int divideIndex = divide(quickSortArr, start, end);

            quickSort(quickSortArr, start, divideIndex - 1);
            quickSort(quickSortArr, divideIndex + 1, end);
        }

        return quickSortArr;
    }
}
