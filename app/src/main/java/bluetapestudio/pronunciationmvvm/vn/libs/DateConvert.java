package bluetapestudio.pronunciationmvvm.vn.libs;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 27/09/2016.
 */

public class DateConvert {
    private static SimpleDateFormat simpleDateFormat;
    private static final String MYSQL_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static CompareStatus compare(Date origin, Date compare) {
        return compare(origin.getTime(), compare.getTime());
    }

    public static CompareStatus compare(long origin, long compare) {
        if (origin > compare) {
            return CompareStatus.ORIGIN_BIGGER;
        } else if (origin < compare) {
            return CompareStatus.COMPARE_BIGGER;
        } else {
            return CompareStatus.EQUAL;
        }
    }

    public static String dateToString(Date date, String format) {
        simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static String dateToString(long dates, String format) {
        return dateToString(new Date(dates), format);
    }

    public static Date stringToDate(String date, String format) throws ParseException {
        simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(date);
    }

    public static long stringToMillis(String date, String format) throws ParseException {
        return stringToDate(date, format).getTime();
    }

    public static String today(String format) {
        if (TextUtils.isEmpty(format)) format = MYSQL_FORMAT;
        return dateToString(new Date(System.currentTimeMillis()), format);
    }

    public enum CompareStatus {
        ORIGIN_BIGGER, EQUAL, COMPARE_BIGGER
    }
}