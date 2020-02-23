package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public static final String WEEK_PATTERN = "E";
    public static final String DISCOUNT_DAY = "周三";
    public static final String DATE_PATTERN = "yyyy年MM月dd日,EEEE";

    public static String formatDate(Date currentDate, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINA);
        return simpleDateFormat.format(currentDate);
    }

    public static Boolean verifyDiscountDay(Date currentDate, String week) {
        return formatDate(currentDate, WEEK_PATTERN).equals(week);
    }
}
