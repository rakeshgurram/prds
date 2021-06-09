package com.bnpp.nepp.service;

import com.bnpp.nepp.model.Payment;
import com.bnpp.nepp.model.PaymentRequest;
import com.bnpp.nepp.model.PaymentResponse;

import java.util.List;

public interface PRDSService {

    public List<Payment> getPayments(PaymentRequest paymentRequest);
    public PaymentResponse getPaymentResponse(PaymentRequest paymentRequest);

}
