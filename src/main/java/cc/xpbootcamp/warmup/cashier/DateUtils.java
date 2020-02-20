package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    private static final String WEEK_PATTERN = "E";

    public static String formatDate(Date currentDate, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINA);
        return simpleDateFormat.format(currentDate);
    }

    public static Boolean verifyDiscountDay(Date currentDate, String week) {
        return formatDate(currentDate, WEEK_PATTERN).equals(week);
    }
}
