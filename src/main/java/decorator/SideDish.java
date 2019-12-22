package decorator;

public class SideDish extends DishDecorator {
    private String name;
    private int weight;
    private int calories;
    private int price;
    public SideDish(IDish iDish, String name, int weight,int calories,int price) {
        super(iDish, name);
        this.name=name;
        this.weight=weight;
        this.calories=calories;
        this.price=price;
    }

    public SideDish(IDish iDish, String name) {
        super(iDish, name);
    }

    @Override
    public String getName() {
        return super.getName() +  " with " + name;
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
        return getName() + " - " + getWeight() + "gr, " + getCalories() + "kkal, " + getPrice() + "zl ";
    }
}
