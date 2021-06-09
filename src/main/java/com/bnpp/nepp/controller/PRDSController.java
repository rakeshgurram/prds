package com.bnpp.nepp.controller;

import com.bnpp.nepp.model.PaymentRequest;
import com.bnpp.nepp.model.PaymentResponse;
import com.bnpp.nepp.service.PRDSService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@NoArgsConstructor
@Api(value = "Api to get payment details ")
public class PRDSController {


    public static final String PAYMENT_DETAILS_ENDPOINT = "/paymentRetrieve";

    @Autowired
    PRDSService prdsService;

    @ApiOperation(value = "THis endpoint consumes PaymentRequest injason and produces PaymentResponse as Json ")
    @GetMapping(value = PAYMENT_DETAILS_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PaymentResponse paymentRetrieve(@RequestBody PaymentRequest paymentRequest){
        PaymentResponse paymentResponse =  prdsService.getPaymentResponse(paymentRequest);
        return paymentResponse;

    }

}
