package com.sbi.back_end_code.controller;

import com.sbi.back_end_code.dao.TranferMoney;
import com.sbi.back_end_code.dao.WithdrawAmount;
import com.sbi.back_end_code.entity.Custumer;
import com.sbi.back_end_code.entity.Transaction;
import com.sbi.back_end_code.service.CustumerService;
import com.sbi.back_end_code.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private CustumerService custumerService;

    @GetMapping("/health_check")
    public String healthCheck(){
        return "Hello Guys! Every thing is fine.";
    }
    @PostMapping("/withdraw")
    public ResponseEntity<Custumer> withdrawMoney(@RequestBody WithdrawAmount withdrawAmount){
        try{
            transactionService.cutAmount(withdrawAmount);
            Custumer custumer = new Custumer();
            custumer = transactionService.findByAccountNo(withdrawAmount.getAccountNo());
            return new ResponseEntity<>(custumer,HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("Error :"+ e.getMessage());
            System.out.println("Why Error is coming :- "+e.getStackTrace());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/transfer")
    public ResponseEntity<Custumer> tranferAmount(@RequestBody TranferMoney tranferMoney){
        try {
            transactionService.tranferMoney(tranferMoney);
            Custumer custumer = new Custumer();
            custumer = transactionService.findByAccountNo(tranferMoney.getSenderAccountNo());
            return new ResponseEntity<>(custumer,HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("Error :"+ e.getMessage());
            System.out.println("Why Error is coming :- "+e.getStackTrace());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
