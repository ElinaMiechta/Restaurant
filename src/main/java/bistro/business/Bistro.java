package bistro.business;

import bistro.iterator.IIterator;
import bistro.iterator.Iterator;
import bistro.iterator.OrderIterator;
import bistro.meal.Dish;
import bistro.meal.IDish;
import bistro.meal.SideDish;
import bistro.people.IClient;
import bistro.people.Waiter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;

public class Bistro implements IIterator{
    private static Bistro instance = null;

    public static Bistro getInstance() {
        if (instance == null) {
            instance = new Bistro();
        }
        return instance;
    }


    Set<IDish> dishesMenu = new HashSet<>();
    Set<IDish> sideDishMenu = new HashSet<>();


    /*
    THis List adds Order as a solitary object
     */
    List<Order> ordersSet = new ArrayList<>();


    String menuJson;
    String sideMenuJson;
    private List<Waiter> waitersList = new ArrayList<>();
    private int totalPrice = 0;
    private int totalIncome = 0;

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<Waiter> getWaitersList() {
        return waitersList;
    }

    /*
    These methods add Dish to Menu and displays it in json format
     */

    public void addToMenuList(IDish iDish) {
        dishesMenu.add(iDish);
    }

    public void addToMenuSideList(IDish iDish) {
        sideDishMenu.add(iDish);
    }


    public void showMenu() {
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        json.toJson(dishesMenu);
        menuJson = json.toJson(dishesMenu);
        System.out.println("Menu of main dishes: \n" + menuJson);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(sideDishMenu);
        sideMenuJson = gson.toJson(sideDishMenu);
        System.out.println("Menu of side dishes: \n" + sideMenuJson);


    }

    public Waiter chooseWaiter() {
        int los = (int) (Math.random() * waitersList.size());
        Waiter chosenWaiter = waitersList.get(los);

        return chosenWaiter;
    }

    public List<Order> getOrdersSet() {
        return ordersSet;
    }

/*
Method connected to Client make order - displays total income, total price, waiters+orders, Also writes Orders to Set
 */

    public void prepareOrder(String dish) {

        for (IDish d : dishesMenu) {
            if (d.getName().equals(dish)) {
                System.out.println("Your order is: " + d);
                totalPrice += d.getPrice();
                totalIncome += d.getPrice();
                System.out.println("Your waiter is: " + chooseWaiter());
                ordersSet.add(new Order(d));

            }
            if (waitersList.contains(chooseWaiter())) {
                chooseWaiter().addRevenue(d.getPrice());
            }
        }

    }

/*
Method connected to Client make order - client can choose a side dish
 */

    public void prepareOrderWithSideDish(String sideDish) {
        for (IDish sd : sideDishMenu) {

            if (sd.getName().equals(sideDish)) {

                System.out.println("Your order is: " + sd);
                totalPrice += sd.getPrice();
                totalIncome += sd.getPrice();
                System.out.println("Your waiter is: " + chooseWaiter());
                System.out.println("Total price for order: " + totalPrice + "zl");
                ordersSet.add(new Order(sd));


            }

            if (waitersList.contains(chooseWaiter())) {
                chooseWaiter().addRevenue(sd.getPrice());
            }


        }
    }

    public void displayTotalIncome() {
        System.out.println("Total Bistro income: " + totalIncome + "zl");

    }

    @Override
    public Iterator getIterator() {
        return new OrderIterator();
    }
}





