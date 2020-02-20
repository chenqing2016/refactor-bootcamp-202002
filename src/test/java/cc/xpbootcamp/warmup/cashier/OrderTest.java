package cc.xpbootcamp.warmup.cashier;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {

    @Test
    public void shouldReturnCorrectPreTaxTotalPrice() {
        List<PurchaseItem> purchaseItems = new ArrayList<PurchaseItem>() {{
            add(new PurchaseItem("milk", 10.0, 2));
            add(new PurchaseItem("biscuits", 5.0, 5));
            add(new PurchaseItem("chocolate", 20.0, 1));
        }};
        Order order = new Order(purchaseItems);
        double result = order.getPreTaxTotalPrice();

        assertThat(result).isEqualTo(65);
    }
}
