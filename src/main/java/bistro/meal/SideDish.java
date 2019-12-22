package bistro.meal;

import java.util.ArrayList;
import java.util.List;

public class SideDish  extends DishDecorator{

    private String name;
    private int weight;
    private int calories;
    private int price;
    private Ingredient ingredient;


    public SideDish(IDish iDish, String name, int weight, int calories, int price,Ingredient ingredient) {
        super( iDish);
        this.name=name;
        this.weight=weight;
        this.calories=calories;
        this.price=price;
        this.ingredient=ingredient;

    }

    public SideDish(String name, IDish iDish) {
        super( iDish);
    }

    @Override
    public String getName() {
        return  name; //+ ", main dish: " + super.getName();
    }

    @Override
    public int getPrice() {
        return super.getPrice() + price;
    }

    @Override
    public int getWeight() {
        return super.getWeight() + weight;
    }

    @Override
    public int getCalories() {
        return super.getCalories() + calories;
    }

    @Override
    public String toString() {
        return getName() + " - " + getWeight() + "gr, " + getCalories() + "kkal, total  price: " + getPrice() + "zl " + "Ingredients: " + ingredient;
    }
}
