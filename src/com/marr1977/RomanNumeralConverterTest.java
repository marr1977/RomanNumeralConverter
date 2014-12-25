package com.marr1977;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by martin hallerdal on 2014-12-25.
 */
public class RomanNumeralConverterTest {

    @Test
    public void toRoman1() {
        assertEquals("MCM", RomanNumeralConverter.toRoman(1900));
    }
    @Test
    public void toRoman2() {
        assertEquals("MCMLXXXIV", RomanNumeralConverter.toRoman(1984));
    }
    @Test
    public void toRoman3() {
        assertEquals("MCDXCVI", RomanNumeralConverter.toRoman(1496));
    }

    @Test
     public void toRoman4() {
        assertEquals("MMM", RomanNumeralConverter.toRoman(3000));
    }

    @Test
     public void toRoman5() {
        assertEquals("III", RomanNumeralConverter.toRoman(3));
    }

    @Test
     public void toRoman6() {
        assertEquals("XI", RomanNumeralConverter.toRoman(11));
    }

    @Test
    public void toRoman7() {
        assertEquals("MMXIV", RomanNumeralConverter.toRoman(2014));
    }

    @Test
    public void toRoman8() {
        assertEquals("LXXXII", RomanNumeralConverter.toRoman(82));
    }

    @Test
    public void toNumber1() {
        assertEquals(1984, RomanNumeralConverter.toNumber("MCMLXXXIV"));
    }

}
