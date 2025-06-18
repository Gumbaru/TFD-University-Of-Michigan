public class QuantityObserver implements OrderObserver {

    @Override
    public void update(Order order) {
        if (order.getItemCount() > 5) {
            order.setShippingCost(0.0);
            System.out.println("QuantityObserver: >5 items, free shipping");
        } else {
            order.setShippingCost(10.0);
            System.out.println("QuantityObserver: <=5 items, shipping cost $10");
        }
    }
}
