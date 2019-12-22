package bistro.business;

import bistro.bonus.Bonus;
import bistro.iterator.Iterator;
import bistro.meal.*;
import bistro.people.Client;
import bistro.people.IClient;
import bistro.people.Waiter;

import java.util.ArrayList;
import java.util.List;

public class Launcher {
    static Bistro bistro = Bistro.getInstance();
    IDish iDish = new IDishImplementation();
    private List<Ingredient> listOfIngredients = new ArrayList<>();

/*
Initializing ingredients
 */


    Ingredient i1 = new Ingredient(iDish, "Roasted pasta(flavour, milk, egg), souse(bazilia,oregano,olive oil)", 200, 420);
    Ingredient i2 = new Ingredient(iDish, "Meat bolls(beaf meat, salt, species,lemon,pepper)", 250, 490);
    Ingredient i3 = new Ingredient(iDish, "Salad(tomato,cucumber, salad leaves,mozarella,gorgonzolla,olive oil,bazilia)", 200, 150);
    Ingredient i4 = new Ingredient(iDish, "Soup(water,bulion,potato,mashrooms,salt)", 400, 130);
    Ingredient i5 = new Ingredient(iDish, "Lo Pello(chiken, cheese, cardamone, salt, coconut milk, oil), souse(bazilia,oregano,olive oil, cheddar)", 300, 520);
    Ingredient i6 = new Ingredient(iDish, "Lasagne(flavour, meat, tomatoes, sour cream, milk, species), souse(bazilia,tomato souse, species)", 500, 500);
    Ingredient i7 = new Ingredient(iDish, "Carbonarra(pasta, onion, bekone), souse(sour cream, solt, egg, cheese)", 400, 550);
    Ingredient i8 = new Ingredient(iDish, "Bolognese(pasta, onion, meat), souse(tomatoes, solt, species, cheese)", 400, 550);
    Ingredient i9 = new Ingredient(iDish, "Rome fish(fish, salt, lemon, pepper)", 350, 280);

    /*
    Initializinf waiters
     */
    Waiter w1 = new Waiter("Alehandro", " Samilio");
    Waiter w2 = new Waiter("Bruno", " Despaccia");
    Waiter w3 = new Waiter("Francheska", " Somilio");


    public void initMenu() {
     /*
     Initializing Menu of Main dishes
      */
        IDish carbonara = new Dish(iDish, "Carbonara", 45, Category.Meat, i7);
        IDish meatBolls = new Dish(iDish, "Meat bolls", 18, Category.Meat, i2);
        IDish lasagne = new Dish(iDish, "Lasagne", 40, Category.Meat, i6);
        IDish soup = new Dish(iDish, "Soup", 18, Category.Soup, i4);
        IDish bolognese = new Dish(iDish, "Bolognese", 15, Category.Others, i8);
        bistro.addToMenuList(carbonara);
        bistro.addToMenuList(meatBolls);
        bistro.addToMenuList(lasagne);
        bistro.addToMenuList(soup);
        bistro.addToMenuList(bolognese);


        /*
        Initializing Menu of Side Dishes
         */
        IDish pasta = new SideDish(iDish, "Pasta", 200, 420, 18, i1);
        IDish tagiatelle = new SideDish(iDish, "Tagiatelle", 120, 400, 15, i1);
        IDish salad = new SideDish(iDish, "Mocarella Salad", 280, 280, 22, i3);
        IDish fish = new SideDish(iDish, "Rome fish", 250, 300, 25, i9);
        IDish loPello = new SideDish(iDish, "Lo pello", 130, 180, 15, i5);
        bistro.addToMenuSideList(pasta);
        bistro.addToMenuSideList(tagiatelle);
        bistro.addToMenuSideList(salad);
        bistro.addToMenuSideList(fish);
        bistro.addToMenuSideList(loPello);
        bistro.showMenu();


    }

    public void initWaiters() {

        bistro.getWaitersList().add(w1);
        bistro.getWaitersList().add(w2);
        bistro.getWaitersList().add(w3);
        System.out.println("Waiters in Bistro: \n" + bistro.getWaitersList());

    }


    public void clientMakesOrder() {
        IClient c1 = new Client("Alisa", "Smith");
        IClient c2 = new Client("Denis", "Melnikov");
        IClient c3 = new Client("Karolina", "Bielicka");
        c1.makeOrder();
        //c2.makeOrder();
       // c3.makeOrder();

        Bonus.getInstance().clientsRandomBonus(c1);
    }

    public void checkWaiterRevenue() {
        System.out.println(w1 + " revenue is: " + w1.showWaiterRevenue());
        System.out.println(w2 + " revenue is: " + w2.showWaiterRevenue());
        System.out.println(w3 + " revenue is: " + w3.showWaiterRevenue());
    }

    public void displayIncome() {
        Bistro.getInstance().displayTotalIncome();
    }

    public void fullInit() {
        initMenu();
        initWaiters();
        clientMakesOrder();
        //System.out.println("=======ITERATOR========");
       // displayOrders();
        //displayIncome();


    }

    public void displayOrders() {

        for (Iterator iter = Bistro.getInstance().getIterator(); iter.hasNext(); ) {
            Order orderIterator = (Order) iter.next();
            System.out.println(orderIterator);

        }
    }


    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        launcher.fullInit();
    }
}
