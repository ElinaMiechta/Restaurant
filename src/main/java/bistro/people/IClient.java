package bistro.people;

import bistro.bonus.IBonus;

public interface IClient extends IBonus {
    String getBonus();
    void makeOrder();
    String getName();

    @Override
    double discount();
}
