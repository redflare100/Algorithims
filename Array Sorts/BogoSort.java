public class BogoSort {
    int[] bogoSort(int[] bogoSortArr){
        while(!sorted(bogoSortArr)){
            shuffle(bogoSortArr);
        }
        return bogoSortArr;
    }

    void shuffle(int[] bogoSort){
        for(int x = 0; x < bogoSort.length; ++x) {
            int index1 = (int) (Math.random() * bogoSort.length), index2 = (int) (Math.random() * bogoSort.length);
            int a = bogoSort[index1];
            bogoSort[index1] = bogoSort[index2];
            bogoSort[index2] = a;
        }
    }

    boolean sorted(int[] bogoSort){
        int count = 1;
        for(int i = 0; i < bogoSort.length; i++){
            if(bogoSort[i] != count){
                return false;
            }

            count++;
        }

        return true;
    }
}
