package bistro.people;

public class Waiter extends Person {
    private String name;
    private String surname;
    private int totalRevenue;
    public int getTotalRevenue(){
        return totalRevenue;
    }
    public Waiter(String name, String surname) {
        super(name, surname);
        this.name=name;
        this.surname=surname;
    }

    public int addRevenue(int x){
        totalRevenue+=x;
        return totalRevenue;
    }

    public int showWaiterRevenue(){
        return getTotalRevenue();
    }


    @Override
    public String toString() {
        return name + " " + surname;
    }
}
