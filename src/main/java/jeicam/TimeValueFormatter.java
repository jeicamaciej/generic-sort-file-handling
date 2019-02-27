package main.java.jeicam;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TimeValueFormatter {
    private final static BigDecimal NS_TO_MS_MULTIPLICATION_VALUE = new BigDecimal(0.00001);

    public static BigDecimal nsToMsValue(long ns) {
        return new BigDecimal(ns).multiply(NS_TO_MS_MULTIPLICATION_VALUE).setScale(2, RoundingMode.HALF_EVEN);
    }
}
