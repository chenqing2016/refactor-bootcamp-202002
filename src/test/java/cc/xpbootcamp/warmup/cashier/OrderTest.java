package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {

    private List<PurchaseItem> purchaseItems;
    private Order order;

    @BeforeEach
    void init() {
        purchaseItems = new ArrayList<PurchaseItem>() {{
            add(new PurchaseItem("milk", 10.0, 2));
            add(new PurchaseItem("biscuits", 5.0, 5));
            add(new PurchaseItem("chocolate", 20.0, 1));
        }};
        order = new Order(purchaseItems);
    }

    @Test
    public void shouldReturnCorrectPreTaxTotalPrice() {

        double result = order.getPreTaxTotalPrice();

        assertThat(result).isEqualTo(65);
    }

    @Test
    public void shouldReturnCorrectTaxPrice() {

        double result = order.getPostTaxPrice();

        assertThat(result).isEqualTo(71.5);
    }
}
