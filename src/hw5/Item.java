package hw5;

public class Item {
    private String description;
    private double cost;
    private double weight;

    public static int itemsCount = 0;


    public Item(String description, double cost, double weight) {
        this.description = description;
        this.cost = cost;
        this.weight = weight;
        itemsCount++;
    }

    public double getCost() {
        return cost;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}
