package cc.xpbootcamp.warmup.cashier;

import java.util.Date;
import java.util.List;

public class Order {

    private List<PurchaseItem> purchaseItemList;
    private static final String DISCOUNT_DAY = "周三";
    private static final double DISCOUNT_RATE = 0.02;
    private static final double TAX_RATE = .10;

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

    public double getPostTaxPrice() {

        double preTaxTotalPrice = getPreTaxTotalPrice();
        return preTaxTotalPrice*TAX_RATE+preTaxTotalPrice;
    }


    public double getDiscountPrice(){
        if (DateUtils.verifyDiscountDay(new Date(), DISCOUNT_DAY)){
            double postTaxPrice = getPostTaxPrice();
            return postTaxPrice* DISCOUNT_RATE;
        }
        return 0d;
    }
}
