package com.sbi.back_end_code.dao;

import org.springframework.stereotype.Component;

@Component
public class WithdrawAmount {
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    private String accountNo;
    private double withdrawAmount;
}
