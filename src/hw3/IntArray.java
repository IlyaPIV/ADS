package hw3;

import java.util.Arrays;
import java.util.Random;

public class IntArray {
    private int[] array;
    private int length;

    public IntArray(int length){
        this.array = new int[length];
        this.length = length;

        Random rnd = new Random();
        int rndInd = rnd.nextInt(length);
        rndInd = 23;
        int currentInd = 0;
        int maxI = rndInd==0 ? length : length+1;
        System.out.println("RND missing value is: "+rndInd);
        for (int i = 1; i <= maxI; i++) {
            if (i!=rndInd) {
                array[currentInd] = i;
                currentInd++;
            }
        }
    }

    public void printArray(){
        System.out.println(Arrays.toString(array));
    }
    public void printArray(int start, int end){
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            System.out.print(" "+array[i]+" ");
        }
        System.out.println("]");
    }

    public void findMissingValue(){

        int missing = 0;
        if (length!=0) {
            if (array[0] == 2) {
                System.out.println("First array's element is not 1.");
                missing = 1;
            }   else if (array[length-1]==length) {
                    System.out.println("Last array's element is correct. Nothing is missing inside.");
                    missing = length+1;
                } else missing = findInsideArray();
        } else {
            System.out.println("Array is empty. No search is needing.");
            missing = 1;
        }

        System.out.println("Missing value is: "+missing);
    }

    private int findInsideArray(){
        int missingValue = 0;
        int iteration = 0;

        int checkingIndex = 1;
        int firstIndex = 0;
        int lastIndex = length-1;
//        System.out.println("Uncorrect part searching:");
//        while (checkingIndex<length){
//            iteration++;
//
//            System.out.printf("#%d: checking: array[%d] (=%d) == %d ?\n",iteration,checkingIndex-1,array[checkingIndex-1],checkingIndex);
//            if (array[checkingIndex-1]!=checkingIndex) {
//                lastIndex = checkingIndex-1;
//                break;
//            } else firstIndex = checkingIndex-1;
//
//            checkingIndex *= 2;
//        }

        while (missingValue==0) {
            iteration++;
            System.out.print("#"+iteration+": wrong value is inside: ");
            printArray(firstIndex, lastIndex);

            int checkingValue = (array[firstIndex]+array[lastIndex])/2;
            checkingIndex = (lastIndex+firstIndex)/2;
            if (checkingIndex==firstIndex) {
                //массив из двух элементов
                missingValue = checkingValue;
            } else
            {
                System.out.printf(">>> checking: array[%d] (%d) = %d ?\n",checkingIndex, array[checkingIndex],checkingValue);
                if (array[checkingIndex]<=checkingValue) firstIndex=checkingIndex;
                    else lastIndex = checkingIndex;
            }
        }

        return missingValue;
    }

}
