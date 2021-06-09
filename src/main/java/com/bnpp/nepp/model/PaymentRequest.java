package com.bnpp.nepp.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class PaymentRequest {
    @Getter
    @Setter
    private String paymentId;

    @Getter @Setter
    private String currency;
}
