package bistro.meal;

import java.util.ArrayList;
import java.util.List;

public class Ingredient extends DishDecorator {
    private String name;
    private int weight;
    private int calories;




    public Ingredient(IDish iDish, String name, int weight, int calories) {
        super( iDish);
        this.name = name;
        this.weight = weight;
        this.calories = calories;
    }

    public Ingredient( IDish iDish) {
        super(iDish);
    }



    @Override
    public String getName() {
        return super.getName() + " consists mainly of:  " + name;
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public int getWeight() {
        return super.getWeight();
    }

    @Override
    public int getCalories() {
        return super.getCalories();
    }

    @Override
    public String toString() {
        return name + ", total weight: " + weight + "gr, ccal: " + calories;
    }



}
