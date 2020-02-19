package cc.xpbootcamp.warmup.cashier;

public class OrderReceipt {
    private Order order;
    private final static String wednesday ="周三";
    private static double discountRate =0.02;
    final DateUtil dateUtil;

    public OrderReceipt(Order order, DateUtil dateUtil) {
        this.order = order;
        this.dateUtil = dateUtil;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        output.append("=====老王超市,值得信赖=====\n");
        output.append("\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
        output.append(dateUtil.formatDate("yyyy年MM月dd日,EEEE"));
        output.append("\n\n");
        StringBuilder purchaseInfo = getPurchaseInfo();
        output.append(purchaseInfo);
        return output.toString();
    }



    public StringBuilder getPurchaseInfo(){
        StringBuilder output = new StringBuilder();
        double totalSalesTax = 0d;
        double totalPrice = 0d;
        double discountPrice=0d;
        Boolean isWednesday = dateUtil.formatDate("E").equals(wednesday);
        for (PurchaseItem purchaseItem : order.getPurchaseItemList()) {
            double calculatedPrice = purchaseItem.calculatePrice();
            output.append(purchaseItem.getDescription());
            output.append(',');
            output.append(purchaseItem.getPrice()+"x"+purchaseItem.getQuantity());
            output.append(',');
            output.append(calculatedPrice);
            output.append('\n');
            double salesTax = calculatedPrice * .10;
            totalSalesTax += salesTax;
            totalPrice += calculatedPrice + salesTax;
            if (isWednesday){
                discountPrice=totalPrice*discountRate;
                totalPrice=totalPrice-discountPrice;
            }
        }
        output.append("-----------------------\n");
        output.append("税额:").append(totalSalesTax).append("\n");
        if (isWednesday){
            output.append("折扣:").append(discountPrice).append("\n");
        }
        output.append("总价:").append(totalPrice);
        return output;
    }
}