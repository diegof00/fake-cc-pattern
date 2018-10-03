package com.ecorp.fakecreditcardpatterndetector.domain;

import java.io.Serializable;
import java.math.BigInteger;


/**
 * This class represent the amount of fake credit cards in
 * a specific date.
 */
public class FakeCreditCardAmount implements Serializable {

    private int dayNumber;
    private BigInteger value;

    public FakeCreditCardAmount(int dayNumber, BigInteger value) {
        this.dayNumber = dayNumber;
        this.value = value;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }
}
