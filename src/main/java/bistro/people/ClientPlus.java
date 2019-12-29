package bistro.people;


import bistro.business.Bistro;

import java.util.Scanner;

public class ClientPlus extends Client implements IClient {
    private String name;
    private String surname;


    @Override
    public void makeOrder() {
        Bistro.getInstance().showMenu();
        String dish;
        String sideDish;
        Scanner scan = new Scanner(System.in);
        System.out.println("Your order:");
        dish = scan.nextLine();


        Bistro.getInstance().prepareOrderForLoyalClient(this, dish);

        System.out.println("Any side dish? Y/N:");
        String decision = scan.nextLine();

        if (decision.equals("y")) {
            System.out.println("Side dish: ");
            sideDish = scan.nextLine();
            Bistro.getInstance().prepareOrderWithSideDish(this, sideDish);


        } else {
            System.out.println("Thank you");
        }
    }


    public ClientPlus(String name, String surname) {
        super(name, surname);
        this.name = name;
        this.surname = surname;
    }
    // как стать лояльным клиентом

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
