package com.sbi.back_end_code.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Custumer")

public class Custumer {

    @Id
    @Column(nullable = false,unique = true)
    private String accountNo;
    @Column(nullable = false)
    private String AccountHolderName;

    private double Balance;
    @OneToMany(mappedBy = "custumer")
    private List<Transaction> transaction =new ArrayList<>();

    @PrePersist
    public void accountNoType(){
        LocalDateTime now =LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyyMMDDHHssSSS");
        this.accountNo="acc"+now.format(formatter);
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountHolderName() {
        return AccountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        AccountHolderName = accountHolderName;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }


}
