package bistro.bonus;

import bistro.business.Bistro;
import bistro.people.Client;
import bistro.people.IClient;

public class Bonus implements IBonus {
    private static double todaysDiscount=0;
    private static Bonus instance = null;

    public static Bonus getInstance(){
        if (instance==null){
            instance=new Bonus();
        }
        return instance;
    }

    public static double getTodaysDiscount() {
        return todaysDiscount;
    }

    /*
    With the help of MAth.random and max amount 10zl system chooses random discount
     */

    public static int setTodaysDiscount() {
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
        System.out.println("Today you have a discount for you order which is:  " + setTodaysDiscount() + " zl " );
        int ordersNewPrice=Bistro.getInstance().getTotalPrice()-setTodaysDiscount();
        System.out.println("Total orders price: ");


        return ordersNewPrice;
    }

    /*
    Turns on the whole mechanism ;)
     */
    public void clientsRandomBonus(IClient client){
        if (client!=null)
            System.out.println(discount());
    }
}
