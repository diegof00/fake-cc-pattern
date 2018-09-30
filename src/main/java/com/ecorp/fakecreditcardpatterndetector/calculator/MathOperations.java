package com.ecorp.fakecreditcardpatterndetector.calculator;

import java.math.BigInteger;

public class MathOperations {

    public static final String FACTORIAL_IS_ONLY_VALID_FOR_NON_NEGATIVE_NUMBERS = "Factorial is only valid for non negative numbers";

    /**
     * Calculate factorial of n
     * @param n
     * @return factorial(n)
     */
    public static BigInteger factorial(int n) {
        if(n<0) {
            throw new IllegalArgumentException(FACTORIAL_IS_ONLY_VALID_FOR_NON_NEGATIVE_NUMBERS);
        }
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= n; i++)
            factorial = factorial.multiply(BigInteger.valueOf(i));
        return factorial;
    }

}
