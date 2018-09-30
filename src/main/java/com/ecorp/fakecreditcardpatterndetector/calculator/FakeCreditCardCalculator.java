package com.ecorp.fakecreditcardpatterndetector.calculator;

import com.ecorp.fakecreditcardpatterndetector.domain.FakeCreditCardAmount;
import com.ecorp.fakecreditcardpatterndetector.domain.FakeCreditCardPatternService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@Slf4j
public class FakeCreditCardCalculator implements FakeCreditCardPatternService {


    public static final String INVALID_DAY_NUMBER = "Invalid dayNumber";

    @Override
    public FakeCreditCardAmount getFakeCreditCardsAmount(Integer dayNumber) {
        if(dayNumber>0 && dayNumber<31) {
            return this.calculateFakeCreditCards(dayNumber);
        }else {
            log.info("invalida day number {}", dayNumber);
            throw new IllegalArgumentException(INVALID_DAY_NUMBER);
        }
    }

    /**
     * This method calculates the next value of the sequence 1,4,18,96,600...
     * the sequence corresponds to n*n!.
     *
     * @param dayNumber
     * @return
     */
    private FakeCreditCardAmount calculateFakeCreditCards(Integer dayNumber) {
        return new FakeCreditCardAmount(dayNumber, BigInteger.valueOf(dayNumber).multiply(MathOperations.factorial(dayNumber)));
    }

}
