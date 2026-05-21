package com.finance.bank.service;

import com.finance.bank.dto.request.CreateAccountRequest;
import com.finance.bank.dto.response.BalanceResponse;
import com.finance.bank.dto.response.CreateAccountResponse;
import com.finance.bank.entity.Account;
import com.finance.bank.exception.AccountNotFoundException;
import com.finance.bank.repository.AccountRepository;
import com.finance.bank.repository.LedgerEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final LedgerEntryRepository ledgerEntryRepository;  // 추가

    // 기존 계좌 개설
    @Transactional
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        Account account = Account.builder()
                .ownerName(request.getOwnerName())
                .build();
        Account saved = accountRepository.save(account);
        return CreateAccountResponse.from(saved);
    }

    // 잔액 조회 추가
    @Transactional(readOnly = true)  // 조회만 하니까 readOnly
    public BalanceResponse getBalance(UUID accountId) {

        // 1. 계좌 존재 확인
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException());

        // 2. ledger_entries 합산으로 잔액 계산
        BigDecimal balance = ledgerEntryRepository.sumAmountByAccountId(accountId);

        // 3. 응답 반환
        return BalanceResponse.of(account, balance);
    }
}