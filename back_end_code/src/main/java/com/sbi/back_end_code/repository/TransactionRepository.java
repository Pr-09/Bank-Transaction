package com.sbi.back_end_code.repository;

import com.sbi.back_end_code.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
