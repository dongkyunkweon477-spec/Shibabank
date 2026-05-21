package com.finance.bank.repository;

import com.finance.bank.entity.LedgerEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.UUID;

public interface LedgerEntryRepository extends JpaRepository<LedgerEntry, UUID> {

    // 잔액 계산 — 해당 계좌의 amount 전체 합산
    @Query("SELECT COALESCE(SUM(l.amount), 0) FROM LedgerEntry l WHERE l.accountId = :accountId")
    BigDecimal sumAmountByAccountId(@Param("accountId") UUID accountId);
}