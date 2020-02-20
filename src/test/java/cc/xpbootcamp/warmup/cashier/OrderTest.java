package cc.xpbootcamp.warmup.cashier;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;


@RunWith(PowerMockRunner.class)
@PrepareForTest({DateUtils.class})
public class OrderTest {

    private List<PurchaseItem> purchaseItems;
    private Order order;

    @Before
    public void init() {
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

    @Test
    public void shouldReturnDiscountTotalPriceWhenDayIsDiscount() {

        PowerMockito.mockStatic(DateUtils.class);
        PowerMockito.when(DateUtils.verifyDiscountDay(any(), any())).thenReturn(true);
        double result = order.getDiscountPrice();

        assertThat(result).isEqualTo(1.43);
    }

    @Test
    public void shouldReturnDiscountTotalPriceWhenDayIsNotDiscount() {

        PowerMockito.mockStatic(DateUtils.class);
        PowerMockito.when(DateUtils.verifyDiscountDay(any(), any())).thenReturn(false);
        double result = order.getDiscountPrice();

        assertThat(result).isEqualTo(0d);
    }
}
