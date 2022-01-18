package hw2;

import java.util.Arrays;
import java.util.Random;


public class Main {



    public static void main(String[] args) {
        int arraySize = 10;
        Notebook[] ourNotebooks = initArray(arraySize);
        System.out.println(Arrays.toString(ourNotebooks));
        sortNotebooks(ourNotebooks);
        System.out.println(Arrays.toString(ourNotebooks));
    }



    public static Notebook[] initArray(int size)
    {
        Random rnd = new Random();
        Notebook[] ourNotebooks = new Notebook[size];
        for (int i = 0; i < size; i++) {
            int price = 500 + 50 * (rnd.nextInt(30));
            int ram = 4 * ((rnd.nextInt(4)+1));
            String manufacturer = rndManufacturer(rnd.nextInt(4));
            ourNotebooks[i] = new Notebook(price, ram, manufacturer);
        }
        return ourNotebooks;
    }

    private static String rndManufacturer(int value){
        return switch (value) {
            case (0) -> "Lenuvo";
            case (1) -> "Asos";
            case (2) -> "MacNote";
            case (3) -> "Eser";
            case (4) -> "Xamiou";
            default -> "";
        };
    }

    public static void sortNotebooks(Notebook[] array){


        for (int i = 0; i < array.length; i++){
            int currentMaxPoz = array.length-1-i;
            if (i == currentMaxPoz) break;

            int min = i;
            int max = currentMaxPoz;


            for (int j = i; j <= currentMaxPoz; j++){
                if (j!=min) {
                    if (array[j].compare(array[min])== -1) min = j; }
                if (j!=max) {
                    if (array[j].compare(array[max])== 1) max = j; }
            }

            if (min==max) {
                break;
            } else if (max == i && min == currentMaxPoz){
                Notebook temp = array[i];
                array[i] = array[currentMaxPoz];
                array[currentMaxPoz] = temp;
            } else {
                Notebook tempFirst = array[i];
                Notebook tempLast = array[currentMaxPoz];
                if (max == i) {
                    array[i] = array[min];
                    array[min] = tempLast;
                    array[currentMaxPoz] = tempFirst;
                } else {
                    array[i] = array[min];
                    array[min] = tempFirst;

                    array[currentMaxPoz] = array[max];
                    array[max] = currentMaxPoz == min ? tempFirst : tempLast;
                }
            }
        }
    }

}
