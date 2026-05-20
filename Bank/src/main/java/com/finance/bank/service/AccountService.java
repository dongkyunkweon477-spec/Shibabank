package com.finance.bank.service;

import com.finance.bank.dto.request.CreateAccountRequest;
import com.finance.bank.dto.response.CreateAccountResponse;
import com.finance.bank.entity.Account;
import com.finance.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public CreateAccountResponse createAccount(CreateAccountRequest request) {

        // 1. Account 엔티티 생성
        Account account = Account.builder()
                .ownerName(request.getOwnerName())
                .build();

        // 2. DB에 저장 (@PrePersist가 자동으로 계좌번호, 상태, 시간 세팅)
        Account saved = accountRepository.save(account);

        // 3. 응답 DTO로 변환해서 반환
        return CreateAccountResponse.from(saved);
    }
}