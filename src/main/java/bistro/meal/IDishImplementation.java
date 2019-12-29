package bistro.meal;

public class IDishImplementation implements IDish{


    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public int getCalories() {
        return 0;
    }

    @Override
    public Category getCategory() {
        return null;
    }
}
