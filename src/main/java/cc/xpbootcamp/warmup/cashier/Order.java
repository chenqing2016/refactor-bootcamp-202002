package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {

    private List<PurchaseItem> purchaseItemList;
    private static final String wednesday = "周三";
    private static final double discountRate = 0.02;
    private static final double taxRate = .10;

    public Order(List<PurchaseItem> purchaseItemList) {

        this.purchaseItemList = purchaseItemList;
    }

    public List<PurchaseItem> getPurchaseItemList() {
        return purchaseItemList;
    }

    public double getPreTaxTotalPrice() {
        List<PurchaseItem> purchaseItemList = this.getPurchaseItemList();
        double preTaxTotalPrice = 0d;
        for (PurchaseItem purchaseItem : purchaseItemList) {
            preTaxTotalPrice += purchaseItem.calculatePurchaseItemPrice();
        }
        return preTaxTotalPrice;
    }

}
