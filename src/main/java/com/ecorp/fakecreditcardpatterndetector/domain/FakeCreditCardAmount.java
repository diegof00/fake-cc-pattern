package com.ecorp.fakecreditcardpatterndetector.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;


/**
 * This class represent the amount of fake credit cards in
 * a specific date.
 */
@Getter
@Setter
@AllArgsConstructor
public class FakeCreditCardAmount implements Serializable {

    private int dayNumber;
    private BigInteger value;

}
