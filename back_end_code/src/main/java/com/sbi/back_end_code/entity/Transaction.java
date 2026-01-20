package com.sbi.back_end_code.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="Transaction")

public class Transaction {
    @Id
    @Column(unique = true,nullable = false)
    private String transactionId;
    @Column(nullable = false)
    private String transactionType;
    private LocalDateTime time;
    @Column(nullable = false)
    private String accountNo;

    private String senderAccountNo;
    private String receiverAccountNo;
    @ManyToOne
    @JoinColumn(name ="custumer")
    private Custumer custumer;

    @PrePersist
    public void transactionIdType(){
        LocalDateTime now =LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyyMMDDHHssSSS");
        this.transactionId="t"+now.format(formatter);
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getSenderAccountNo() {
        return senderAccountNo;
    }

    public void setSenderAccountNo(String senderAccountNo) {
        this.senderAccountNo = senderAccountNo;
    }

    public String getReceiverAccountNo() {
        return receiverAccountNo;
    }

    public void setReceiverAccountNo(String receiverAccountNo) {
        this.receiverAccountNo = receiverAccountNo;
    }

    public Custumer getCustumer() {
        return custumer;
    }

    public void setCustumer(Custumer custumer) {
        this.custumer = custumer;
    }
}
