package com.ecorp.fakecreditcardpatterndetector;

import com.ecorp.fakecreditcardpatterndetector.domain.FakeCreditCardPatternService;
import com.ecorp.fakecreditcardpatterndetector.web.FakeCreditCardAmountRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FakeCreditCardPatternDetectorApplicationTests {

    @Autowired
    private FakeCreditCardPatternService fakeCreditCardPatternService;

    @Autowired
    private FakeCreditCardAmountRestController fakeCreditCardAmountRestController;

    @Test
    public void contextLoads() {
        assertNotNull(fakeCreditCardPatternService);
        assertNotNull(fakeCreditCardAmountRestController);
    }

}
