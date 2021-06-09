package com.bnpp.nepp.service;

import com.bnpp.nepp.model.PaymentRequest;
import com.bnpp.nepp.util.RequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class ValidatorImpl implements Validator {

     public void validate(PaymentRequest paymentRequest) throws RequestException{

        if(paymentRequest == null ){
            throw new RequestException("request null");
        }else {
            validateData(paymentRequest);
        }
    }


    public  void validateData(PaymentRequest paymentRequest) throws RequestException{
        if(paymentRequest.getPaymentId().isBlank()){
            throw new RequestException("request PaymentId null");
        }else if(isSpecialCharacterExist(paymentRequest.getPaymentId())){
            throw new RequestException("request Contains Special Character");
        }else if(paymentRequest.getCurrency().isBlank()){
            throw new RequestException("request Currency null");
        }else if(! isCurrencyAllowed(paymentRequest.getCurrency())){
            throw new RequestException("request Currency null");
        }
    }

    public boolean isSpecialCharacterExist(String str){
        boolean isSpecialCharStr = false;
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(str);
        isSpecialCharStr = matcher.find();
        return isSpecialCharStr;
    }

    public boolean isCurrencyAllowed(String str){
        boolean isAllowed = false;
        if(str.equalsIgnoreCase("INR") || str.equalsIgnoreCase("EURO" )){
            isAllowed = true;
        }
        return isAllowed;
    }



}

