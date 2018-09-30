package com.ecorp.fakecreditcardpatterndetector.calculator;

import com.ecorp.fakecreditcardpatterndetector.domain.FakeCreditCardAmount;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FakeCreditCardCalculatorTest {

    public static final int DAY_ONE = 1;
    public static final int DAY_TWO = 2;
    public static final int DAY_THREE = 3;
    public static final int DAY_FOUR = 4;
    public static final int DAY_FIVE = 5;
    private static final int DAY_SIX = 6;

    private final static String FIRST_DAY_VALUE = "1";
    private final static String SECOND_DAY_VALUE = "4";
    private final static String THIRD_DAY_VALUE = "18";
    private final static String FOURTH_DAY_VALUE = "96";
    private final static String FIFTH_DAY_VALUE = "600";
    private final static String SIXTH_DAY_VALUE = "4320";
    private FakeCreditCardCalculator testedClass;

    @Before
    public void setup() {
        testedClass = new FakeCreditCardCalculator();
    }

    /**
     * this test checks the sequence 1.4.18.96.600.4320
     */
    @Test
    public void testCalculateFakeCreditCardPattern() {
        assertEquals(new BigInteger(FIRST_DAY_VALUE), testedClass.getFakeCreditCardsAmount(DAY_ONE).getValue());
        assertEquals(new BigInteger(SECOND_DAY_VALUE), testedClass.getFakeCreditCardsAmount(DAY_TWO).getValue());
        assertEquals(new BigInteger(THIRD_DAY_VALUE), testedClass.getFakeCreditCardsAmount(DAY_THREE).getValue());
        assertEquals(new BigInteger(FOURTH_DAY_VALUE), testedClass.getFakeCreditCardsAmount(DAY_FOUR).getValue());
        assertEquals(new BigInteger(FIFTH_DAY_VALUE), testedClass.getFakeCreditCardsAmount(DAY_FIVE).getValue());
        assertEquals(new BigInteger(SIXTH_DAY_VALUE), testedClass.getFakeCreditCardsAmount(DAY_SIX).getValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateFakeCreditCardPatternZeroDay() {
        testedClass.getFakeCreditCardsAmount(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateFakeCreditCardPatternWithNegativeValue() {
        testedClass.getFakeCreditCardsAmount(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateFakeCreditCardPatternWithLongerValue() {
        testedClass.getFakeCreditCardsAmount(32);
    }

}
