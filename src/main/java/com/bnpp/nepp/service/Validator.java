package com.bnpp.nepp.service;

import com.bnpp.nepp.model.PaymentRequest;
import com.bnpp.nepp.util.RequestException;
import org.springframework.stereotype.Service;



public interface Validator {

    void validate(PaymentRequest paymentRequest) throws RequestException;
    void validateData(PaymentRequest paymentRequest) throws RequestException;
}
