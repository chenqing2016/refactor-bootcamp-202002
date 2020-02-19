package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mock;
class OrderReceiptTest {

    @Mock
    static DateUtil mockDate;

    @BeforeAll
     static void initAll(){
        mockDate = mock(DateUtil.class);
        when(mockDate.formatDate("yyyy年MM月dd日,EEEE")).thenReturn("");
        when(mockDate.formatDate("E")).thenReturn("周二");
    }
    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<PurchaseItem>());

        OrderReceipt receipt = new OrderReceipt(order, mockDate);

        String output = receipt.printReceipt();


        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformationWhenDayIsNotWednesday() throws ParseException {
        List<PurchaseItem> purchaseItems = new ArrayList<PurchaseItem>() {{
            add(new PurchaseItem("milk", 10.0, 2));
            add(new PurchaseItem("biscuits", 5.0, 5));
            add(new PurchaseItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, purchaseItems), mockDate);


        String output = receipt.printReceipt();
        System.out.println(output);
        assertThat(output,containsString("=====老王超市,值得信赖====="));
        assertThat(output, containsString("milk,10.0x2,20.0\n"));
        assertThat(output, containsString("biscuits,5.0x5,25.0\n"));
        assertThat(output, containsString("chocolate,20.0x1,20.0\n"));
        assertThat(output,containsString("-----------------------\n"));
        assertThat(output, containsString("税额:6.5\n"));
        assertThat(output, containsString("总价:71.5"));
    }

    @Test
    public void shouldPrintLineDiscountPriceWhenDayIsWednesday(){
        List<PurchaseItem> purchaseItems = new ArrayList<PurchaseItem>() {{
            add(new PurchaseItem("milk", 10.0, 2));
        }};
        when(mockDate.formatDate("E")).thenReturn("周三");
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, purchaseItems), mockDate);


        String output = receipt.printReceipt();
        System.out.println(output);
        assertThat(output, containsString("折扣:0.44"));
        assertThat(output,containsString("总价:21.56"));
    }
}