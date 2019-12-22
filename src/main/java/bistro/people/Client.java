package bistro.people;

import bistro.business.Bistro;
import bistro.business.Order;

import java.util.Scanner;

public class Client extends Person implements IClient{
    private String name;
    private String surname;
    private IClient iClient;


    public Client(String name, String surname) {
        super(name, surname);
    }


    public String getName() {
        return this.iClient.getName();
    }

    @Override
    public void makeOrder() {
        Bistro.getInstance().showMenu();
        String dish;
        String sideDish;
        Scanner scan = new Scanner(System.in);
        System.out.println("Your order:");
        dish=scan.nextLine();
        Bistro.getInstance().prepareOrder(dish);

        System.out.println("Any side dish? Y/N:");
        String decision = scan.nextLine();

        if (decision.equals("y")){
            System.out.println("Side dish: ");
            sideDish=scan.nextLine();
            Bistro.getInstance().prepareOrderWithSideDish(sideDish);
        }else{
            System.out.println("Thank you");
        }






    }

    @Override
    public String getBonus() {
        return null;
    }

    @Override
    public String toString() {
        return getName();
    }
}
