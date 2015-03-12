package de.myvideo.java8.future;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Util {

    private static final NumberFormat formatter = new DecimalFormat("#", new DecimalFormatSymbols(Locale.US));

    public static void delay() {
        int delay = 1000;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int format(int number) {
        synchronized (formatter) {
            return new Integer(formatter.format(number));
        }
    }

}
