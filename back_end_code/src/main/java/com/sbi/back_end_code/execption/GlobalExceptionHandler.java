package com.sbi.back_end_code.execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustumerUserDefineExcepiton.class)
    public ResponseEntity<Map<String,String>> handlerResourceNotFound(CustumerUserDefineExcepiton ex){
        Map<String ,String> apiResponse= new HashMap<>();
        apiResponse.put("message", ex.getMessage());
        apiResponse.put("success","true");
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);

    }
}
