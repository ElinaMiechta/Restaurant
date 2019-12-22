package decorator;

public class DishDecorator implements IDish {
    protected IDish iDish;
    protected String name;

    public DishDecorator(IDish iDish, String name) {
        this.iDish = iDish;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.iDish.getName();
    }

    @Override
    public int getPrice() {
        return this.iDish.getPrice();
    }

    @Override
    public int getWeight() {
        return this.iDish.getWeight();
    }

    @Override
    public int getCalories() {
        return this.iDish.getCalories();
    }
}
