package cc.xpbootcamp.warmup.cashier;

import java.util.Date;

public class OrderReceipt {

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        output.append(printHeader());
        output.append(printPurchaseDetailInfo());
        return output.toString();
    }

    public StringBuilder printHeader() {
        StringBuilder output = new StringBuilder();
        output.append("=====老王超市,值得信赖=====\n");
        output.append("\n");
        output.append(DateUtils.formatDate("yyyy年MM月dd日,EEEE", new Date()));
        output.append("\n\n");
        return output;
    }

//    public StringBuilder calculateTaxAndDiscount(double totalPrice) {
//        StringBuilder output = new StringBuilder();
//        double discountPrice = 0;
//        double currentTotalPrice = totalPrice;
//        Boolean isDiscountDay = dateUtils.verifyDiscountDay(wednesday);
//        double salesTax = totalPrice * taxRate;
//        currentTotalPrice = totalPrice + salesTax;
//        if (isDiscountDay) {
//            discountPrice = currentTotalPrice * discountRate;
//            currentTotalPrice -= discountPrice;
//        }
//
//        if (isDiscountDay) {
//            output.append("折扣:").append(discountPrice).append("\n");
//        }
//        output.append("总价:").append(currentTotalPrice);
//        return output;
//    }

    public StringBuilder printPurchaseDetailInfo() {
        StringBuilder output = new StringBuilder();
        for (PurchaseItem purchaseItem : order.getPurchaseItemList()) {
            double calculatedPrice = purchaseItem.calculatePurchaseItemPrice();
            output.append(purchaseItem.getDescription());
            output.append(',');
            output.append(purchaseItem.getPrice() + "x" + purchaseItem.getQuantity());
            output.append(',');
            output.append(calculatedPrice);
            output.append('\n');
        }
        output.append("-----------------------\n");
        return output;
    }

    public StringBuilder printFooter() {

        double taxPrice = order.getTaxPrice();
        double discountPrice = order.getDiscountPrice();
        double preTaxTotalPrice = order.getPreTaxTotalPrice();
        StringBuilder output = new StringBuilder();
        output.append("税额:").append(taxPrice).append("\n");
        if (DateUtils.verifyDiscountDay(new Date(), Constants.DISCOUNT_DAY)) {
            output.append("折扣:").append(discountPrice).append("\n");
        }
        output.append("总价:").append(preTaxTotalPrice + taxPrice - discountPrice);
        return output;
    }
}