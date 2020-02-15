package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private String customerName;
    private String customerAddress;
    private List<PurchaseItem> purchaseItemList;

    public Order(String customerName, String address, List<PurchaseItem> purchaseItemList) {
        this.customerName = customerName;
        this.customerAddress = address;
        this.purchaseItemList = purchaseItemList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<PurchaseItem> getPurchaseItemList() {
        return purchaseItemList;
    }
}
