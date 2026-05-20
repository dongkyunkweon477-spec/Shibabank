package com.finance.bank.repository;

import com.finance.bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    // 계좌번호로 조회
    Optional<Account> findByAccountNumber(String accountNumber);
}