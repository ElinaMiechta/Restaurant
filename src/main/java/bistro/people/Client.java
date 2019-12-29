package bistro.people;

import bistro.bonus.Bonus;
import bistro.bonus.IBonus;
import bistro.business.Bistro;
import bistro.meal.Category;

import java.util.Scanner;

public class Client extends Person implements IClient, IBonus {
    private String name;
    private String surname;
    private IClient iClient;


    public Client(String name, String surname) {
        super(name, surname);
        this.name=name;
        this.surname=surname;
    }


    public String getName() {
        return this.iClient.getName();
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void makeOrder() {
        Bistro.getInstance().showMenu();
        String dish;
        String sideDish;
        Scanner scan = new Scanner(System.in);
        System.out.println("Your order:");
        dish = scan.nextLine();

        Bistro.getInstance().prepareOrder(this, dish);


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

    @Override
    public String getBonus() {
        return null;
    }

    @Override
    public String toString() {
        return name + " " +  surname;
    }


    @Override
    public double discount() {


        System.out.println("Choose number:");
        System.out.println("33,    54,    6,   13 ");
        Scanner scan = new Scanner(System.in);
        String decision = scan.nextLine();

        switch (decision) {
            case "33":
                System.out.println("Congratulation! ");
                System.out.println(Bonus.getInstance().discount());
                break;

            case "54":
                Bonus.getInstance().ifCategoryCorrect(Category.Others);
                break;


                /*
                Does not count % discount in a proper way - shows results but the total price after mathematics is wrong!
                 */
            case "6":
                System.out.println("Congratulations!");
                System.out.println("Your bonus is: % ");


                System.out.printf("%.1f", Bonus.getInstance().percentageBonus()); // устанавливает Бонус %


                System.out.println();

                System.out.println("Total order price: zl");
                double newTotalPrice = Bonus.getInstance().priceAfterDiscount(Bistro.getInstance().getTotalPrice(), Bonus.getInstance().percentageBonus());

                System.out.printf("%.1f", newTotalPrice);

                break;

            case "13":
                Bonus.getInstance().discountForMeatCategory(this);
                break;


        }
        return 0;
    }


}
