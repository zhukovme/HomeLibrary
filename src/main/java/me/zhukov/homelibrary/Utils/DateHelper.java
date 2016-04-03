package me.zhukov.homelibrary.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Michael Zhukov
 */
public enum DateHelper {

    INSTANCE;

    public static final String DATE_FORMAT = "yyyy-mm-dd";

    public Date stringToDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
