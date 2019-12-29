package bistro.business;

import bistro.iterator.IIterator;
import bistro.iterator.Iterator;
import bistro.iterator.OrderIterator;
import bistro.meal.Category;
import bistro.meal.IDish;
import bistro.people.ClientPlus;
import bistro.people.IClient;
import bistro.people.Waiter;
import com.google.gson.*;
import java.util.*;

public class Bistro implements IIterator {
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


    private String menuJson;
    private String sideMenuJson;
    private List<Waiter> waitersList = new ArrayList<>();
    private int totalPrice = 0;
    private int totalIncome = 0;
    private double newPrice = 0;
    private int amount = 1;
    private String savedOrders;
    Map<IClient, List<Order>> savingOrders = new HashMap<>();

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



    /*
    Randomly picks up the Waiter from waitersList
     */


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

    public Set<IDish> getDishesMenu() {
        return dishesMenu;
    }

    public boolean ifClientIsLoyal(IClient c) {
        for (Map.Entry<IClient, Integer> m : mapOfAmountsOfDishes.entrySet()) {
            if (m.getKey().equals(c) && m.getValue() > 2) {

                return true;
            }
        }
        return false;

    }

    /*
    Prepare dish for Loyal Clients
     */
    public void prepareOrderForLoyalClient(ClientPlus clientPlus, String dish) {
        for (IDish d : dishesMenu) {
            if (d.getName().equals(dish)) {
                System.out.println("Your order is: " + d);
            }
            if (clientPlus != null && d.getCategory() == Category.Others) {
                System.out.println(discountForOthersCategory(d));
                totalPrice += (int) newPrice;
                totalIncome += totalPrice;
                System.out.println("Total price for order: " + totalPrice + "zl");
                System.out.println("Your waiter is: " + chooseWaiter());
                ordersSet.add(new Order(d));
                amount++;


                if (waitersList.contains(chooseWaiter())) {
                    chooseWaiter().addRevenue((int) totalPrice);
                }

            }
        }
    }

    public void prepareOrder(IClient client, String dish) {

        for (IDish d : dishesMenu) {
            if (d.getName().equals(dish)) {
                System.out.println("Your order is: " + d);

                totalPrice = 0;
                totalPrice += d.getPrice();
                totalIncome += d.getPrice();
                System.out.println("Total price for order: " + totalPrice + "zl");
                System.out.println("Your waiter is: " + chooseWaiter());
                ordersSet.add(new Order(d));
                savingOrders.put(client, ordersSet);

                addOrderToSpecificClient(client, d);
                mapOfAmountsOfDishes.put(client, amount++);


            }
            if (waitersList.contains(chooseWaiter())) {
                chooseWaiter().addRevenue(d.getPrice());
            }

        }
        if (ifClientIsLoyal(client)) {
            System.out.println("From next order you have a permanent loyality discount at our Bistro!");
        }
    }



/*
Method connected to Client make order - client can choose a side dish
 */


    public void prepareOrderWithSideDish(IClient iClient, String sideDish) {
        for (IDish sd : sideDishMenu) {

            if (sd.getName().equals(sideDish)) {

                System.out.println("Your order is: " + sd);
                totalPrice += sd.getPrice();
                totalIncome += sd.getPrice();
                System.out.println("Your waiter is: " + chooseWaiter());
                System.out.println("Total price for order: " + totalPrice + "zl");
                ordersSet.add(new Order(sd));
                savingOrders.put(iClient, ordersSet);

                addOrderToSpecificClient(iClient, sd);


            }

            if (waitersList.contains(chooseWaiter())) {
                chooseWaiter().addRevenue(sd.getPrice());
            }


        }
    }

    public void displayTotalIncome() {
        System.out.println("Total Bistro income: " + totalIncome + "zl");

    }

    public int getTotalIncome() {
        return totalIncome;
    }

    @Override
    public Iterator getIterator() {
        return new OrderIterator();
    }

    /*
    Adding orders to specific Clients to make possible adding Loyality Discount and also to grant a discout for special Category of dish

*/
    /*
    mapOfAmountOfDishes - ads how many dishes it has been ordered by specific client
     */


    private Map<IClient, IDish> mapClient_Order = new HashMap<>();

    private Map<IClient, Integer> mapOfAmountsOfDishes = new HashMap<>();

    public Map<IClient, Integer> getMapOfAmountsOfDishes() {
        return mapOfAmountsOfDishes;
    }


    public void displayMapOfAmunt() {
        for (Map.Entry<IClient, Integer> m : mapOfAmountsOfDishes.entrySet()) {
            System.out.println(m.getKey());
            System.out.println(m.getValue());
        }
    }

    public void addAmountToMap(IClient client) {
        if (mapOfAmountsOfDishes.containsKey(client)) {
            amount++;
            mapOfAmountsOfDishes.put(client, amount);
        }


    }


    public Map<IClient, IDish> getMapClient_Order() {
        return mapClient_Order;
    }

    public void addOrderToSpecificClient(IClient client, IDish order) {
        mapClient_Order.put(client, order);

    }

    public void displayMapOfClientAndOrders() {
        for (Map.Entry<IClient, IDish> m : mapClient_Order.entrySet()) {
            System.out.println(m.getKey());
            System.out.println(m.getValue());
        }

    }


    public double discountForOthersCategory(IDish iDish) {
        if (iDish.getCategory().equals(Category.Others)) {
            newPrice = iDish.getPrice() - 10;
            System.out.println("After  loyalty discount  dish cost  is: ");

            return newPrice;

        }

        return iDish.getPrice();

    }
}





