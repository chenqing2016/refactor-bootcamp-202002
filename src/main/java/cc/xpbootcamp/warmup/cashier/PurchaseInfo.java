package cc.xpbootcamp.warmup.cashier;

public class PurchaseInfo {
	private String description;
	private double price;
	private int quantity;

	public PurchaseInfo(String desc, double price, int qty) {
		this.description = desc;
		this.price = price;
		this.quantity = qty;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double calculateTotalPrice() {
        return price * quantity;
    }
}