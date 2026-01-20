package com.sbi.back_end_code.service;


import com.sbi.back_end_code.dao.TranferMoney;
import com.sbi.back_end_code.dao.WithdrawAmount;
import com.sbi.back_end_code.entity.Custumer;
import com.sbi.back_end_code.entity.Transaction;
import com.sbi.back_end_code.execption.CustumerUserDefineExcepiton;
import com.sbi.back_end_code.repository.CustumerRepository;
import com.sbi.back_end_code.repository.TransactionRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CustumerRepository custumerRepository;

    public Custumer findByAccountNo(String accountNO){
        return custumerRepository.findByAccountNo(accountNO);
    }
    public void cutAmount(@NotNull WithdrawAmount withdrawAmount) throws CustumerUserDefineExcepiton {
        Custumer custumer;
        custumer = custumerRepository.findByAccountNo(withdrawAmount.getAccountNo());
        if(null!=custumer){
            if(custumer.getBalance()>=withdrawAmount.getWithdrawAmount()){
                Transaction transaction = new Transaction();
                transaction.setTransactionType("Withdraw");
                transaction.setAccountNo(withdrawAmount.getAccountNo());
                transaction.setTime(LocalDateTime.now());
                transaction.setCustumer(custumer);
                transaction.setReceiverAccountNo("No Receiver");
                transaction.setSenderAccountNo("No Sender");
                Transaction saved=transactionRepository.save(transaction);

                custumer.setBalance(custumer.getBalance() - withdrawAmount.getWithdrawAmount());
                custumer.getTransaction().add(saved);
                custumerRepository.save(custumer);
            }else
                throw new CustumerUserDefineExcepiton("Insufficient balance");
        }else
            throw new CustumerUserDefineExcepiton("This Account No. User Not found In DB");

    }

    public void tranferMoney(TranferMoney tranferMoney) throws CustumerUserDefineExcepiton {
        Custumer sender,receiver;
        sender = custumerRepository.findByAccountNo(tranferMoney.getSenderAccountNo());
        receiver=custumerRepository.findByAccountNo(tranferMoney.getReceiverAccountNo());
        if ((sender != null) && (receiver != null)){
            if (sender.getBalance()>=tranferMoney.getAmount()){
                Transaction transaction = new Transaction();
                transaction.setTransactionType("Transfer");
                transaction.setAccountNo(tranferMoney.getSenderAccountNo());
                transaction.setTime(LocalDateTime.now());
                transaction.setCustumer(sender);
                transaction.setReceiverAccountNo(tranferMoney.getReceiverAccountNo());
                transaction.setSenderAccountNo(tranferMoney.getSenderAccountNo());
                Transaction saved=transactionRepository.save(transaction);

                sender.setBalance(sender.getBalance() - tranferMoney.getAmount());
                receiver.setBalance(receiver.getBalance()+tranferMoney.getAmount());

                sender.getTransaction().add(saved);
                custumerRepository.save(sender);
                custumerRepository.save(receiver);
            }else
                throw new CustumerUserDefineExcepiton("Insufficient balance Of the Sender");
        }else
            throw new CustumerUserDefineExcepiton("This Sender and Reciver. User Not found In DB");
    }
}
