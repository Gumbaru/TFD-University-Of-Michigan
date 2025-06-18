public class PriceObserver implements OrderObserver {

    @Override
    public void update(Order order) {
        if (order.getTotalPrice() > 200) {
            double newTotal = order.getTotalPrice() - 20;
            // on décrémente le total directement pour l’exemple
            // tu peux aussi ajouter une propriété discount si tu préfères
            System.out.printf("PriceObserver: >$200, apply $20 discount. New total=%.2f%n", newTotal);
            // Si tu veux modifier order.totalPrice, il faut expander l’API Order
        }
    }
}
