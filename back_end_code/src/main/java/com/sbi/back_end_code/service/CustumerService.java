package com.sbi.back_end_code.service;

import com.sbi.back_end_code.entity.Custumer;
import com.sbi.back_end_code.repository.CustumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustumerService {
    @Autowired
    private CustumerRepository custumerRepository;
    public void saveCustumer(Custumer custumer) {
        custumerRepository.save(custumer);
    }
}
