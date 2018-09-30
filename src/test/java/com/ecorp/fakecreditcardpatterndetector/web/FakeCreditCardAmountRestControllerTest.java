package com.ecorp.fakecreditcardpatterndetector.web;


import com.ecorp.fakecreditcardpatterndetector.domain.FakeCreditCardAmount;
import com.ecorp.fakecreditcardpatterndetector.domain.FakeCreditCardPatternService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FakeCreditCardAmountRestController.class)
public class FakeCreditCardAmountRestControllerTest {

    public static final int DAY_NUMBER = 6;
    public static final String VALUE_FOR_SIXTH_DAY = "4320";
    public static final String VALUE_FOR_FIFTH_DAY = "600";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FakeCreditCardPatternService fakeCreditCardPatternService;

    private FakeCreditCardAmount fakeCreditCardAmountExpectedFifthDay;
    private FakeCreditCardAmount fakeCreditCardAmountExpectedSixthDay;

    private ObjectMapper mapper;


    @Before
    public void setup() throws JsonProcessingException {
        mapper = new ObjectMapper();
        fakeCreditCardAmountExpectedFifthDay = new FakeCreditCardAmount(DAY_NUMBER, new BigInteger(VALUE_FOR_FIFTH_DAY));
        fakeCreditCardAmountExpectedSixthDay = new FakeCreditCardAmount(DAY_NUMBER, new BigInteger(VALUE_FOR_SIXTH_DAY));

        when(fakeCreditCardPatternService.getFakeCreditCardsAmount(5)).thenReturn(fakeCreditCardAmountExpectedFifthDay);
        when(fakeCreditCardPatternService.getFakeCreditCardsAmount(6)).thenReturn(fakeCreditCardAmountExpectedSixthDay);
        when(fakeCreditCardPatternService.getFakeCreditCardsAmount(-1)).thenThrow(new IllegalArgumentException("Factorial not defined for negative values"));

    }

    @Test
    public void testRestFakeCreditCardAmountReturnfifthDayValue() throws Exception {
        String expectedJson5thDay = mapper.writeValueAsString(fakeCreditCardAmountExpectedFifthDay);
        this.mockMvc.perform(get("/api/fakeCreditCardAmount/5")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(expectedJson5thDay)));
    }

    @Test
    public void testSixthDayValueAsDefault() throws Exception {
        String expectedJson6thDay = mapper.writeValueAsString(fakeCreditCardAmountExpectedSixthDay);
        this.mockMvc.perform(get("/api/fakeCreditCardAmount/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(expectedJson6thDay)));
    }

    @Test
    public void testInvalidDayNumberNegativeValue() throws Exception {
        this.mockMvc.perform(get("/api/fakeCreditCardAmount/-1")).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(status().reason("Invalid dayNumber argument"));
    }


    @Test
    public void testInvalidDayNumberStringValue() throws Exception {
        this.mockMvc.perform(get("/api/fakeCreditCardAmount/edfcwe")).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(status().reason("Invalid dayNumber argument"));
    }

}
