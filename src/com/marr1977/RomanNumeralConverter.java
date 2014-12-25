package com.marr1977;

import java.util.*;

/**
 * Created by martin hallerdal on 2014-12-25.
 */
public class RomanNumeralConverter {

    private static final List<RomanNumeral> sortedNumerals;

    static {
        // Sort the numerals in descending order

        sortedNumerals = Arrays.asList(RomanNumeral.values());

        Collections.sort(sortedNumerals, new Comparator<RomanNumeral>() {
            @Override
            public int compare(RomanNumeral o1, RomanNumeral o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                if (o1.getValue() < o2.getValue()) {
                    return 1;
                }

                return 0;
            }
        });
    }

    /**
     * Returns a romal numeral string for a given value
     *
     * @param value
     * @return
     */
    public static String toRoman(long value) {
        StringBuffer buffer = new StringBuffer();

        if (value < 0) {
            throw new IllegalArgumentException("Negative numbers not supported");
        }

        long left = value;

        while(left > 0) {
            String bestMatch = bestMatch(left);

            buffer.append(bestMatch);

            left -= toNumber(bestMatch);
        }

        return buffer.toString();
    }

    /**
     * Returns the value of a roman numeral
     *
     * @param roman
     * @return
     * @throws IllegalArgumentException
     */
    public static long toNumber(String roman) throws IllegalArgumentException {
        long totalValue = 0;
        Long lastValue = null;

        for (int i = 0; i < roman.length(); i++) {
            long value =
                RomanNumeral.valueOf(roman.substring(i, i + 1)).getValue();

            if (lastValue != null && lastValue < value) {
                totalValue -= 2 * lastValue;
            }

            totalValue += value;

            lastValue = value;
        }

        return totalValue;
    }

    /**
     * Get the best romal numeral match for a value
     *
     * @param left
     * @return
     */
    private static String bestMatch(long left) {
        for (RomanNumeral numeral : sortedNumerals) {
            if (numeral.getValue() <= left) {
                return numeral.name();
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * Defines all the roman numerals, including the allowed subtractive notations since that
     * makes parsing much cleaner.
     */
    public enum RomanNumeral {
        I(1),
        IV(4),
        V(5),
        IX(9),
        X(10),
        XL(40),
        L(50),
        XC(90),
        C(100),
        CD(400),
        D(500),
        CM(900),
        M(1000);

        long value;

        RomanNumeral(long value) {
            this.value = value;
        }

        public long getValue() {
            return value;
        }
    }
}

