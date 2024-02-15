public class SortTesting {
    
    public static void printArray(int[] array){
        System.out.print("[");

        for(int i = 0; i < array.length - 1; i++){
            System.out.print(array[i] + ", ");
        }

        System.out.println(array[array.length - 1]+ "]");
    }

    public static void main(String[] args) {
        int[] masterArray = {10, 8, 6, 5, 3, 7, 9, 4, 1, 2};
        System.out.println("Master Array: ");
        printArray(masterArray);

        System.out.println("====== Quick Sort =====");
        int[] quickSortArr = {10, 8, 6, 5, 3, 7, 9, 4, 1, 2};
        
        long quickSortStart = System.nanoTime();
        
        QuickSort quick = new QuickSort(); //Creates a new Quick Sort.
        quickSortArr = quick.quickSort(quickSortArr, 0, quickSortArr.length - 1);
        
        long quickSortEnd = System.nanoTime();

        System.out.println("Quick Sort Complete: ");
        printArray(quickSortArr);
        System.out.println("Time to complete (in Nanoseconds): " + (quickSortEnd - quickSortStart));

        System.out.println("====== Merge Sort =====");
        int[] mergeSortArr = {10, 8, 6, 5, 3, 7, 9, 4, 1, 2};
        
        long mergeSortStart = System.nanoTime();
        
        MergeSort merge = new MergeSort();
        mergeSortArr = merge.mergeSort(mergeSortArr, mergeSortArr.length);

        long mergeSortEnd = System.nanoTime();
        
        System.out.println("Merge Sort Complete: ");
        printArray(mergeSortArr);
        System.out.println("Time to complete (in Nanoseconds): " + (mergeSortEnd - mergeSortStart));

        System.out.println("====== Insertion Sort =====");
        int[] insertionSortArr = {10, 8, 6, 5, 3, 7, 9, 4, 1, 2};
        
        long insertionSortStart = System.nanoTime();
        //Do Insertion Sort
        long insertionSortEnd = System.nanoTime();

        System.out.println("Insertion Sort Complete: ");
        printArray(insertionSortArr);

        System.out.println("Time to complete (in Nanoseconds): " + (insertionSortEnd - insertionSortStart));
        
        System.out.println("====== Bubble Sort =====");
        int[] bubbleSortArr = {10, 8, 6, 5, 3, 7, 9, 4, 1, 2};
        
        long bubbleSortStart = System.nanoTime();
        //Do Bubble Sort
        long bubbleSortEnd = System.nanoTime();
        
        System.out.println("Bubble Sort Complete: ");
        printArray(bubbleSortArr);
        System.out.println("Time to complete (in Nanoseconds): " + (bubbleSortEnd - bubbleSortStart));
        
        System.out.println("====== Bogo Sort =====");
        int[] bogoSortArr = {10, 8, 6, 5, 3, 7, 9, 4, 1, 2};
        
        long bogoSortStart = System.nanoTime();
        
        BogoSort bogo = new BogoSort();
        bogoSortArr = bogo.bogoSort(bogoSortArr);

        long bogoSortEnd = System.nanoTime();
        System.out.println("Bogo Sort Complete: ");
        printArray(bogoSortArr);
        System.out.println("Time to complete (in Nanoseconds): " + (bogoSortEnd - bogoSortStart));
    }
}
