package bistro.bonus;

import bistro.business.Bistro;
import bistro.meal.Category;
import bistro.meal.IDish;
import bistro.people.IClient;

import java.util.Calendar;
import java.util.Map;

public class Bonus implements IBonus {
    private static double todaysDiscount = 0;
    private static Bonus instance = null;

    public static Bonus getInstance() {
        if (instance == null) {
            instance = new Bonus();
        }
        return instance;
    }

    public static double getTodaysDiscount() {
        return todaysDiscount;
    }

    /*
    With the help of MAth.random and max amount 10zl system chooses random discount
     */

    public static double setTodaysDiscount() {
        int amount = 10; // amout of possible disscount
        int los = (int) (Math.random() * amount);

        Bonus.todaysDiscount = los;
        return los;
    }

    /*
    Informs about discount, its amount and also shows newOrdersPrice
     */

    @Override
    public double discount() {
        setTodaysDiscount();
        System.out.println("Today you have a discount for you order which is:  " + todaysDiscount + " zl ");
        double ordersNewPrice = Bistro.getInstance().getTotalPrice() - todaysDiscount;
        System.out.println("Total order price: ");


        return ordersNewPrice;
    }

    /*
    Turns on the whole mechanism ;)
     */

    public void clientsRandomBonus(IClient client) {
        if (client != null)
            System.out.println(discount());
    }


    public double percentageBonus() {
        double maxPercentageDiscount = 25.0;

        double los = (Math.random() * maxPercentageDiscount);


        return los;

    }

    public double loyalityPercentageBonus(double totalPrice){
        double maxPercentageDiscount = 15.0;
        double result = totalPrice-(maxPercentageDiscount/100)*maxPercentageDiscount; //logic is unproved

        return result;
    }

    public double priceAfterDiscount(double number, double percent) {
        double result = number / 100 * percent;
        //double result = Bistro.getInstance().getTotalPrice()-(procentDiscount/100);

        return number - result;

    }

    /*

    - check if IDish category in map is equal to MEAT
    - picks up a discount
     */

    public boolean discountForMeatCategory(IClient client) {
        for (Map.Entry<IClient, IDish> c : Bistro.getInstance().getMapClient_Order().entrySet()) {
            if (c.getKey().equals(client)) {
                if (c.getValue().getCategory().equals(Category.Meat)) {
                    System.out.println("Your discount for dish from lucky category MEAT is " + discount());
                    return true;
                }
            }

        }
        System.out.println("maybe next time...");
        return false;
    }

    /*
    Discount 5zl for fish dishes
     */
    public boolean ifCategoryCorrect(Category categoryName) {
        for (Map.Entry<IClient, IDish> c : Bistro.getInstance().getMapClient_Order().entrySet()) {
            if (c.getValue().getCategory().equals(categoryName)) {
                System.out.println("You have discount for your order: 5zl!");
                int newPrice = c.getValue().getPrice() - 5;
                System.out.println("Your price is: " + newPrice + " zl");
                return true;
            }
        }
        System.out.println("Not this time, have a nice meal!");
        return false;


    }


}
