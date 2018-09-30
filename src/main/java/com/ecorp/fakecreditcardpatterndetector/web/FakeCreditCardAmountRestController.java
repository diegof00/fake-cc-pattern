package com.ecorp.fakecreditcardpatterndetector.web;

import com.ecorp.fakecreditcardpatterndetector.domain.FakeCreditCardAmount;
import com.ecorp.fakecreditcardpatterndetector.domain.FakeCreditCardPatternService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
@Slf4j
public class FakeCreditCardAmountRestController {

    @Autowired
    private FakeCreditCardPatternService fakeCreditCardPatternService;

    @GetMapping(value = {"/fakeCreditCardAmount/", "/fakeCreditCardAmount/{dayNumber}"}, produces = "application/json")
    public FakeCreditCardAmount getFakeCreditCardAmount(@PathVariable Optional<Integer> dayNumber) {
        log.info("processing request for dayNumber: {}", dayNumber);
        return dayNumber.isPresent() ? fakeCreditCardPatternService.getFakeCreditCardsAmount(dayNumber.get())
                :fakeCreditCardPatternService.getFakeCreditCardsAmount(6);
    }
}
