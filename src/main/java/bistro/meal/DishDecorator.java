package bistro.meal;

public class DishDecorator implements IDish {

    protected IDish iDish;


    public DishDecorator( IDish iDish) {

        this.iDish = iDish;
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

    @Override
    public Category getCategory() {
        return this.iDish.getCategory();
    }
}
