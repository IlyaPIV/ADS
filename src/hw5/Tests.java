package hw5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tests {
    public static void main(String[] args) {
        System.out.println("==== TESTING POW NUMBERS====");
        testPow(2, 3);
        testPow(2, 5);
        testPow(2, -3);
        testPow(2, 0);
        testPow(2, 1);
        testPow(5, 4);
        testPow(10, -2);

        //задача с мешком
        System.out.println();
        System.out.println("====== TESTING ITEMS TO BAG =======");
        testBagTask(6,5);
    }

    //возведение в степень
    public static void testPow(int value, int powValue){
        System.out.printf("Число %d в степени %d равно = %.4f\n", value, powValue, myPOW(value, powValue));
    }

    private static double myPOW(int value, int powValue){

        boolean negative = false;
        if (powValue<0) {
            powValue = -powValue;
            negative = true;
        }

        if (powValue == 0) return 1.0;
        else if (powValue == 1) return 1.0*value;
           else return negative ? 1.0 / (value * myPOW(value, powValue-1)) : 1.0 * value * myPOW(value, powValue-1);

    }


    //задача с мешком
    public static void testBagTask(float maxWeight, int itemsCount){
        Bag bag = new Bag(maxWeight);
        List<Item> avaliableItems = getItemsList(itemsCount);
        System.out.println(avaliableItems.toString());
        bag.findAndPlaceBestCombination(avaliableItems);
        bag.showItems();
    }

    private static List<Item> getItemsList(int count){
        List<Item> list = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < count; i++) {
            double rndWeight = 0.1 + 0.1*rnd.nextInt(55);
            double cost = 1.0 + 0.1 * rnd.nextInt(2500);
            Item newItem = new Item("New_item_"+Item.itemsCount, cost, rndWeight);
            list.add(newItem);
        }

        return list;
    }


}
