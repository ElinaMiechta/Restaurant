package bistro.iterator;

import bistro.business.Bistro;
import bistro.business.Order;

public class OrderIterator implements Iterator {
    int index = 0;

    @Override
    public boolean hasNext() {

        if (index < Bistro.getInstance().getOrdersSet().size()) {

            return true;
        }

        return false;
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            Order order =Bistro.getInstance().getOrdersSet().get(index);
            index++;
            return order;
        }

        return null;
    }

}
