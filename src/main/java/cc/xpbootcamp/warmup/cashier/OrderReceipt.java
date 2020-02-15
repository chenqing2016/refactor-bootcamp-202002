package cc.xpbootcamp.warmup.cashier;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
        StringBuilder purchaseInfo = getPurchaseInfo();
        output.append(purchaseInfo);
        return output.toString();
    }
    public StringBuilder getPurchaseInfo(){
        StringBuilder output = new StringBuilder();
        double totSalesTx = 0d;
        double tot = 0d;
        for (PurchaseItem purchaseItem : order.getPurchaseItemList()) {
            double calculatedPrice = purchaseItem.calculatePrice();
            output.append(purchaseItem.getDescription());
            output.append('\t');
            output.append(purchaseItem.getPrice());
            output.append('\t');
            output.append(purchaseItem.getQuantity());
            output.append('\t');
            output.append(calculatedPrice);
            output.append('\n');
            double salesTax = calculatedPrice * .10;
            totSalesTx += salesTax;
            tot += calculatedPrice + salesTax;
        }
        output.append("Sales Tax").append('\t').append(totSalesTx);
        output.append("Total Amount").append('\t').append(tot);
        return output;
    }
}