package hw2;

import java.util.Objects;

public class Notebook {
    private int price;
    private int RAM;
    private String manufacturer;


    public Notebook(int price, int RAM, String manufacturer){
        this.price = price;
        this.RAM = RAM;
        this.manufacturer = manufacturer;

    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", RAM=" + RAM +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return price == notebook.price && RAM == notebook.RAM && Objects.equals(manufacturer, notebook.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, RAM, manufacturer);
    }


    public int compare(Notebook secondNotebook){
        if (this==secondNotebook) return 0;
        if (this.price == secondNotebook.price) {
            if (this.RAM == secondNotebook.RAM) {
                return  (getManufacturerPrio(this.manufacturer) > getManufacturerPrio(secondNotebook.manufacturer))
                        ? 1 : -1;
            } else return this.RAM > secondNotebook.RAM ? 1 : -1;
        }
        else return this.price > secondNotebook.price ? 1 : -1;

    }

    private int getManufacturerPrio(String manufacturer){
        return switch (manufacturer) {
            case ("Xamiou") -> 1;
            case ("Eser") -> 2;
            case ("MacNote") -> 3;
            case ("Asos") -> 4;
            case ("Lenuvo") -> 5;
            default -> 0;
        };
    }
}
