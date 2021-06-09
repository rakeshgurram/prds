package com.bnpp.nepp.controller;

import com.bnpp.nepp.model.Error;
import com.bnpp.nepp.model.ErrorList;
import com.bnpp.nepp.model.PaymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {

    @InitBinder
    private void activateDirectFieldAccess(DataBinder dataBinder){ dataBinder.initDirectFieldAccess(); }

    @ExceptionHandler
    public ResponseEntity<?> genericError(HttpServletRequest request, Exception e) {
        String path = request.getServletPath();
        logException(e, path);
        PaymentResponse paymentResponse = new PaymentResponse();
        ErrorList errorSet = new ErrorList();
        List<Error> errorList = new ArrayList();
        Error error = new Error();
        error.setErrorId("1000");
        error.setMessage("Internal Server Error");
        errorList.add(error);
        errorSet.setError(errorList);
        paymentResponse.setErrorList(errorSet);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(paymentResponse);
    }

    public void logException(Exception e, String path) {

        log.info("generic error source = {} ", path);
        log.error("generic error = {} ", e);
    }


}
