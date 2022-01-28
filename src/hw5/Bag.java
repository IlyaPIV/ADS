package hw5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Bag {

    private final float MAX_WEIGHT;
    private double current_weight;
    private List<Item> itemsList;

    public Bag(float MAX_WEIGHT) {
        this.MAX_WEIGHT = MAX_WEIGHT;
        this.current_weight = 0;
        this.itemsList = new ArrayList<>();
    }

    public double getCurrent_weight() {
        return current_weight;
    }

    public boolean canBePlacedInside(float weight){
        return (MAX_WEIGHT-current_weight)>=weight;
    }

    public void showItems(){
        if (itemsList.size()==0) System.out.println("The Bag is empty.");
        else {
            System.out.println("Items inside: ");
            for (Item item :
                    itemsList) {
                System.out.println(">> " + item.toString());
            }
            System.out.println("Total count: "+itemsList.size());
            System.out.println("Total weight: "+current_weight);
        }
    }

    @Override
    public String toString() {
        return "Bag{" +
                "MAX_WEIGHT=" + MAX_WEIGHT +
                ", current weight=" + current_weight +
                ", items inside=" + itemsList.size() +
                '}';
    }

    public void findAndPlaceBestCombination(List<Item> list){
        double listWeight = checkWeight(list);
        if (listWeight<=MAX_WEIGHT) {
            System.out.println("All items can be places inside bag!!!");
            this.itemsList = list;
            this.current_weight = listWeight;
        } else {
            System.out.println("Checking best combination:");
            this.itemsList = checkCombination(list, listWeight, summCost(list),0, list, "1");
            this.current_weight = checkWeight(list);
        }
    }

    private double checkWeight(List<Item> itemsList){
        double weight = 0;
        for (Item item:
             itemsList) {
            weight+= item.getWeight();
        }
        return weight;
    }

    private double summCost(List<Item> itemsList){
        double summ = 0;
        for (Item item:
             itemsList) {
            summ+=item.getCost();
        }
        return summ;
    }

    private List<Item> checkCombination(List<Item> allItemsInside,double allItemsWeight,double allItemsCost, double bestCost,  List<Item> bestSetup, String lvl){

        int iteration = 0;
        for (Item removingItem:
             allItemsInside) {
            iteration++;
            List<Item> checkingItemsCombination = new ArrayList<>(allItemsInside);
            checkingItemsCombination.remove(removingItem);

            System.out.printf("%s.%d: Checking combination: ",lvl,iteration);
            System.out.println(checkingItemsCombination.toString());

            double combiWeight = allItemsWeight-removingItem.getWeight();
            double sumOfCombination = allItemsCost-removingItem.getCost();

            if (combiWeight<=MAX_WEIGHT) {

                if (sumOfCombination>bestCost) {
                    System.out.println(">>>This combo is current best.");
                    bestCost = sumOfCombination;
                    bestSetup = checkingItemsCombination;
                }

            } else {
                List<Item> resultCombination = checkCombination(checkingItemsCombination, combiWeight, sumOfCombination, bestCost, bestSetup, lvl+"."+iteration);
                double resultCost = summCost(resultCombination);
                if (resultCost>bestCost) {
                    bestCost = resultCost;
                    bestSetup = resultCombination;
                }
            }
        }

        return bestSetup;
    }

}
