package decorator;

import bistro.meal.Category;

public class Restaurant {


    public static void main(String[] args) {
        IDish idish = new IDishImplementation();
        IDish carbonara = new Dish(idish, "Carbonara", 45, Category.Meat);
        IDish meatBolls = new Dish(idish, "Meat bolls", 18, Category.Meat);
        System.out.println("Your order: " + meatBolls);
        IDish pasta = new SideDish(meatBolls, "pasta", 250, 350, 20);
        System.out.println("Your order all together with side dish: " + pasta);


        IDish cheeseSticks = new SideDish(carbonara, "Cheese sticks", 120, 360, 14);
        System.out.println(cheeseSticks);

    }


}
