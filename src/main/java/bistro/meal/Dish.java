package bistro.meal;

import java.util.ArrayList;
import java.util.List;

public class Dish extends DishDecorator {

    private String name;
    private int price;
    private Category category;
    private Ingredient ingredient;

    public Dish(IDish iDish, String name, int price, Category category, Ingredient ingredient) {
        super( iDish);
        this.name = name;
        this.price = price;
        this.category = category;
        this.ingredient=ingredient;
    }

    public Dish(String name, IDish iDish) {
        super(iDish);
    }

    @Override
    public String getName() {
        return  name;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + price;
    }

    @Override
    public int getWeight() {
        return super.getWeight();
    }

    @Override
    public int getCalories() {
        return super.getCalories();
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return getName() + " " + getPrice() + "zl, contains: " + category + ". Ingredients: " + ingredient;
    }


}
