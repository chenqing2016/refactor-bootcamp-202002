package cc.xpbootcamp.warmup.cashier;

import java.util.Date;
import java.util.List;

public class Order {

    private List<PurchaseItem> purchaseItemList;
    private static final double DISCOUNT_RATE = 0.02;
    private static final double TAX_RATE = .10;
    double preTaxTotalPrice = 0d;

    Order(List<PurchaseItem> purchaseItemList) {

        this.purchaseItemList = purchaseItemList;
        this.preTaxTotalPrice = getPreTaxTotalPrice();
    }

    List<PurchaseItem> getPurchaseItemList() {
        return purchaseItemList;
    }

    double getPreTaxTotalPrice() {
        List<PurchaseItem> purchaseItemList = this.getPurchaseItemList();
        double preTaxTotalPrice = 0d;
        for (PurchaseItem purchaseItem : purchaseItemList) {
            preTaxTotalPrice += purchaseItem.calculatePurchaseItemPrice();
        }
        return preTaxTotalPrice;
    }

    double getTaxPrice() {

        double preTaxTotalPrice = this.getPreTaxTotalPrice();
        return preTaxTotalPrice * TAX_RATE;
    }


    double getDiscountPrice() {
        if (DateUtils.verifyDiscountDay(new Date(), DateUtils.DISCOUNT_DAY)) {
            double postTaxPrice = getTaxPrice() + this.getPreTaxTotalPrice();
            return postTaxPrice * DISCOUNT_RATE;
        }
        return 0d;
    }
}
