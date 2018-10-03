package com.ecorp.fakecreditcardpatterndetector.web;

import com.ecorp.fakecreditcardpatterndetector.domain.FakeCreditCardAmount;
import com.ecorp.fakecreditcardpatterndetector.domain.FakeCreditCardPatternService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class FakeCreditCardAmountRestController {

    private static final Logger log = LoggerFactory.getLogger(FakeCreditCardAmountRestController.class);

    @Autowired
    private FakeCreditCardPatternService fakeCreditCardPatternService;

    @GetMapping(value = {"/fakeCreditCardAmount/", "/fakeCreditCardAmount/{dayNumber}"}, produces = "application/json")
    public FakeCreditCardAmount getFakeCreditCardAmount(@PathVariable Optional<Integer> dayNumber) {
        log.info("processing request for dayNumber: {}", dayNumber);
        return dayNumber.isPresent() ? fakeCreditCardPatternService.getFakeCreditCardsAmount(dayNumber.get())
                :fakeCreditCardPatternService.getFakeCreditCardsAmount(6);
    }
}
