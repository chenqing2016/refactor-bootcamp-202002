package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static String formatDate(String pattern, Date currentDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINA);
        return simpleDateFormat.format(currentDate);
    }

    public static Boolean verifyDiscountDay(Date currentDate, String week) {
        return formatDate("E", currentDate).equals(week);
    }
}
