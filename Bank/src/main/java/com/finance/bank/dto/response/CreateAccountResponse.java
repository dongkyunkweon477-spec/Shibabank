package com.finance.bank.dto.response;

import com.finance.bank.entity.Account;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class CreateAccountResponse {

    private final UUID accountId;
    private final String accountNumber;
    private final String ownerName;
    private final String status;
    private final LocalDateTime createdAt;

    // Account 엔티티를 응답 DTO로 변환
    public static CreateAccountResponse from(Account account) {
        return new CreateAccountResponse(account);
    }

    private CreateAccountResponse(Account account) {
        this.accountId     = account.getId();
        this.accountNumber = account.getAccountNumber();
        this.ownerName     = account.getOwnerName();
        this.status        = account.getStatus().name();
        this.createdAt     = account.getCreatedAt();
    }
}