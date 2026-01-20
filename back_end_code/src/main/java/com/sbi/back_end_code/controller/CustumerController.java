package com.sbi.back_end_code.controller;

import com.sbi.back_end_code.entity.Custumer;
import com.sbi.back_end_code.service.CustumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Costumer")
public class CustumerController {

    @Autowired
    private CustumerService custumerService;

    @GetMapping("/health_check")
    public String healthCheck(){
        return "Hello Guys! Every thing is fine.";
    }

    @PostMapping
    public ResponseEntity<Custumer> createCostumer(@RequestBody Custumer custumer){
        try {
            custumerService.saveCustumer(custumer);

            return new ResponseEntity<>(custumer, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
