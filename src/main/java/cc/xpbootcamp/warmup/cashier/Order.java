package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private String customerName;
    private String customerAddress;
    private List<PurchaseInfo> purchaseInfoList;

    public Order(String customerName, String address, List<PurchaseInfo> purchaseInfoList) {
        this.customerName = customerName;
        this.customerAddress = address;
        this.purchaseInfoList = purchaseInfoList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<PurchaseInfo> getLineItems() {
        return purchaseInfoList;
    }
}
