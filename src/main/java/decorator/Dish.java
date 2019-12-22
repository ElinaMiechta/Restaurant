package decorator;

import bistro.meal.Category;

public class Dish extends DishDecorator {
    private String name;
    private int price;
    private Category category;


    public Dish(IDish iDish, String name, int price, Category category) {
        super(iDish, name);
        this.name=name;
        this.price = price;
        this.category = category;
    }

    public Dish(IDish iDish, String name) {
        super(iDish, name);
    }

    @Override
    public String getName() {
        return super.getName() + " " + this.name;
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

    @Override
    public String toString() {
        return getName() + " " + getPrice() + "zl, contains: " + category;
    }
}
