package com.sbi.back_end_code.repository;

import com.sbi.back_end_code.entity.Custumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustumerRepository extends JpaRepository<Custumer,String> {
//    @Autowired
//    private CustumerRepository custumerRepository;
//   static Custumer findCustumerbyAccountNo(String accountNo){
//       if(null!=custumerRepository.findBy(accountNo)){
//
//       }
//       return
//   }
    Custumer findByAccountNo(String accountNo);
}
