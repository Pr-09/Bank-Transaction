package com.sbi.back_end_code.execption;

import org.springframework.stereotype.Component;

//@Component
public class CustumerUserDefineExcepiton extends RuntimeException{
    public CustumerUserDefineExcepiton() {
        System.out.println("Excepiton is generated !");
    }

    public CustumerUserDefineExcepiton(String message){
       super(message);
   }
}
