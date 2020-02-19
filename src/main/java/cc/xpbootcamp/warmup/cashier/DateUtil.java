package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    Date currentDate = new Date();

    public String formatDate(String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINA);
        return simpleDateFormat.format(currentDate);
    }

    public Boolean verifyDiscountDay(String week) {
        return formatDate("E").equals(week);
    }
}
