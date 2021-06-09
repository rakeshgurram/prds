package com.bnpp.nepp.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PAYMENTDETAILS")
public class Payment {

    @Getter
    @Setter
    @Column(name="id")
    @Id
    private String paymentId;

    @Getter @Setter
    @Column(name="amount")
    private String amount;

    @Getter @Setter
    @Column(name="currency")
    private String currency;

    @Getter @Setter
    @Column(name="transact")
    private String transact;

    @Getter @Setter
    @Column(name="settlementinformation")
    private String settlementinformation;

    @Getter @Setter
    @Column(name="creditorid")
    private String creditorid;

    @Getter @Setter
    @Column(name="debitorid")
    private String debitorid;

    @Getter @Setter
    @Column(name="creditornumber")
    private String creditornumber;

    @Getter @Setter
    @Column(name="debitornumber")
    private String debitornumber;

    @Getter @Setter
    @Column(name="creditorname")
    private String creditorname;

    @Getter @Setter
    @Column(name="debitorname")
    private String debitorname;

    @Getter @Setter
    @Column(name="datetimestamp")
    private String timestamp;

}
