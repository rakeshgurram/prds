package com.bnpp.nepp.model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
public class PaymentResponse {
    @Getter
    @Setter
    private Payment payment;

    @Getter @Setter
    private List<Payment> paymentList;

    @Getter @Setter
    private ErrorList errorList;
}
