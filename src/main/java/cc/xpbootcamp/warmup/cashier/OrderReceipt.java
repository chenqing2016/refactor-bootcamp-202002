package cc.xpbootcamp.warmup.cashier;

public class OrderReceipt {

    private Order order;
    private final static String wednesday = "周三";
    private final static double discountRate = 0.02;
    private final static double taxRate = .10;
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

    public StringBuilder calculateTaxAndDiscount(double totalPrice) {
        StringBuilder output = new StringBuilder();
        double discountPrice = 0;
        double currentTotalPrice = totalPrice;
        Boolean isDiscountDay = dateUtil.verifyDiscountDay(wednesday);
        double salesTax = totalPrice * taxRate;
        currentTotalPrice = totalPrice + salesTax;
        if (isDiscountDay) {
            discountPrice = currentTotalPrice * discountRate;
            currentTotalPrice -= discountPrice;
        }
        output.append("税额:").append(salesTax).append("\n");
        if (isDiscountDay) {
            output.append("折扣:").append(discountPrice).append("\n");
        }
        output.append("总价:").append(currentTotalPrice);
        return output;
    }

    public StringBuilder getPurchaseInfo() {
        StringBuilder output = new StringBuilder();
        double totalPrice = 0d;
        for (PurchaseItem purchaseItem : order.getPurchaseItemList()) {
            double calculatedPrice = purchaseItem.calculatePurchaseItemPrice();
            output.append(purchaseItem.getDescription());
            output.append(',');
            output.append(purchaseItem.getPrice() + "x" + purchaseItem.getQuantity());
            output.append(',');
            output.append(calculatedPrice);
            output.append('\n');
            totalPrice += calculatedPrice;
        }
        output.append("-----------------------\n");
        StringBuilder taxAndDiscountPriceInfo = calculateTaxAndDiscount(totalPrice);
        output.append(taxAndDiscountPriceInfo);
        return output;
    }

}