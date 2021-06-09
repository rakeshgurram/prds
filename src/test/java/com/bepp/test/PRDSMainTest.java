package com.bepp.test;

import com.bnpp.nepp.PRDSMain;
import com.bnpp.nepp.model.PaymentRequest;
import com.bnpp.nepp.service.PRDSService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PRDSMainTest {

    @Autowired
    PRDSService prdsService;

    @Test
    public void  getPaymentResponse(){
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setPaymentId("asdjk6e5");
        paymentRequest.setCurrency("INR");

        prdsService.getPaymentResponse(paymentRequest);

        Assert.assertEquals("1001", prdsService.getPaymentResponse(paymentRequest).getErrorList().getError().get(0).getErrorId() );
    }


}
