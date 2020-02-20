package cc.xpbootcamp.warmup.cashier;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DateUtils.class})
public class OrderReceiptTest {

    private List<PurchaseItem> purchaseItems;
    private OrderReceipt receipt;

    @Before
    public void init(){
        purchaseItems = new ArrayList<PurchaseItem>() {{
            add(new PurchaseItem("milk", 10.0, 2));
            add(new PurchaseItem("biscuits", 5.0, 5));
            add(new PurchaseItem("chocolate", 20.0, 1));
        }};
         receipt = new OrderReceipt(new Order(purchaseItems));
    }

    @Test
    public void shouldPrintHeaderInfo(){

        PowerMockito.mockStatic(DateUtils.class);
        PowerMockito.when(DateUtils.formatDate(any(), any())).thenReturn("2020年02月20日,星期三");

        String result = receipt.printHeader().toString();

        assertThat(result,containsString("=====老王超市,值得信赖====="));
        assertThat(result,containsString("2020年02月20日,星期三"));
    }

    @Test
    public void shouldPrintPurchaseDetailInformation(){

        String output = receipt.printPurchaseDetailInfo().toString();

        assertThat(output, containsString("milk,10.0x2,20.0\n"));
        assertThat(output, containsString("biscuits,5.0x5,25.0\n"));
        assertThat(output, containsString("chocolate,20.0x1,20.0\n"));
        assertThat(output,containsString("-----------------------\n"));
    }

    @Test
    public void shouldPrintFooterInfoWhenDayIsNotOffDay(){

        PowerMockito.mockStatic(DateUtils.class);
        PowerMockito.when(DateUtils.verifyDiscountDay(any(), any())).thenReturn(false);

        String result=receipt.printFooter().toString();

        assertThat(result,containsString("税额:6.5"));
        assertThat(result,containsString("总价:71.5"));

    }

    @Test
    public void shouldPrintFooterInfoWhenDayIsOffDay(){

        PowerMockito.mockStatic(DateUtils.class);
        PowerMockito.when(DateUtils.verifyDiscountDay(any(), any())).thenReturn(true);

        String result=receipt.printFooter().toString();

        assertThat(result,containsString("税额:6.5"));
        assertThat(result,containsString("总价:70.07"));
        assertThat(result,containsString("折扣:1.43"));

    }


}