package com.bnpp.nepp.service;

import com.bnpp.nepp.model.Error;
import com.bnpp.nepp.model.ErrorList;
import com.bnpp.nepp.model.Payment;
import com.bnpp.nepp.model.PaymentRequest;
import com.bnpp.nepp.model.PaymentResponse;
import com.bnpp.nepp.repo.PRDSRepository;
import com.bnpp.nepp.util.RequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PRDSServiceImpl implements PRDSService{

    @Autowired
    PRDSRepository prdsRepository;

    @Autowired
    Validator validator;

    @Override
    public PaymentResponse getPaymentResponse(PaymentRequest paymentRequest){

        PaymentResponse paymentResponse = new PaymentResponse();

        try {

        validator.validate(paymentRequest);
        List<Payment> paymentList = getPayments(paymentRequest);
        if(!paymentList.isEmpty()){
            paymentResponse.setPaymentList(paymentList);
        }else{
            paymentResponse = getPaymentsError("1001", "Data records not found in db");
        }
        }catch (RequestException rex){
            paymentResponse =  getPaymentsError("1002", rex.getMessage());
        }catch (Exception rex){
            paymentResponse = getPaymentsError("1003", rex.getMessage());

        }
        return paymentResponse;
    }


    @Override
    @Transactional
    public List<Payment> getPayments(PaymentRequest paymentRequest) {

        List<Payment> payentList = new ArrayList<>();
        prdsRepository.findAll().forEach(event -> payentList.add(event));
        List<Payment> eventList2 = new ArrayList<>();
        if(paymentRequest.getPaymentId() != null ){
            eventList2 =  payentList.stream().filter(event -> event.getPaymentId().equalsIgnoreCase(paymentRequest.getPaymentId())).collect(Collectors.toList());
        }else{
            eventList2 =  payentList.stream().filter(event -> event.getCurrency().equalsIgnoreCase(paymentRequest.getCurrency())).collect(Collectors.toList());
        }
        return eventList2;
    }//'2021-04-16T20:00:00Z'


    public PaymentResponse getPaymentsError(String errorId, String erroMsg) {

        PaymentResponse paymentResponse = new PaymentResponse();
        ErrorList errorSet = new ErrorList();
        List<Error> errorList = new ArrayList();
        Error error = new Error();
        error.setErrorId(errorId);
        error.setMessage(erroMsg);
        errorList.add(error);
        errorSet.setError(errorList);
        paymentResponse.setErrorList(errorSet);

        return paymentResponse;
    }//'2021-04-16T20:00:00Z'
}
