package com.ecorp.fakecreditcardpatterndetector.calculator;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class MathOperationsTest {

    @Test
    public void testFactorial() {
        assertEquals(BigInteger.valueOf(120), MathOperations.factorial(5));
        assertEquals(BigInteger.valueOf(720), MathOperations.factorial(6));
        assertEquals(new BigInteger("2432902008176640000"), MathOperations.factorial(20));
    }

    @Test
    public void testOneFactorial() {
        assertEquals(BigInteger.ONE, MathOperations.factorial(1));
    }

    @Test
    public void testZeroFactorial() {
        assertEquals(BigInteger.ONE, MathOperations.factorial(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeFactorial() {
        MathOperations.factorial(-1);
    }

}
