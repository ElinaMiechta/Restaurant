package bistro.business;

import bistro.iterator.IIterator;
import bistro.iterator.Iterator;
import bistro.meal.IDish;
import bistro.people.IClient;

import java.util.List;

public class Order  {
    private IDish iDish;
    private IClient iClient;
    int index=0;

    public Order(IDish iDish) {
        this.iDish = iDish;
    }

    @Override
    public String toString() {
        return " Dish: " + iDish.getName() + ",price: " + iDish.getPrice() + " zl" ;
    }
}
