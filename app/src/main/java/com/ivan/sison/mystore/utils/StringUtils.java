package com.ivan.sison.mystore.utils;

import java.text.DecimalFormat;

public class StringUtils {

    public static String getFormattedPrice(String price) {
        double amount = Double.parseDouble(price);
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        return formatter.format(amount);
    }
}
