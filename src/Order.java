import java.util.ArrayList;
import java.util.List;

public class Order {
    private long id;
    private int itemCount;
    private double totalPrice;
    private double shippingCost;
    private List<OrderObserver> observers = new ArrayList<>();

    public Order(long id) {
        this.id = id;
        this.itemCount = 0;
        this.totalPrice = 0.0;
        this.shippingCost = 10.0; // valeur par défaut
    }

    public void attach(OrderObserver o) {
        observers.add(o);
    }

    public void detach(OrderObserver o) {
        observers.remove(o);
    }

    public void addItem(double price) {
        // mise à jour des attributs
        itemCount++;
        totalPrice += price;
        // notification des observers
        for (OrderObserver o : observers) {
            o.update(this);
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return String.format("Order[id=%d, items=%d, total=%.2f, shipping=%.2f]",
                id, itemCount, totalPrice, shippingCost);
    }
}
