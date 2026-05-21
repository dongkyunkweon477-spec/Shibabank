package com.finance.bank.dto.response;

import com.finance.bank.entity.Account;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class BalanceResponse {

    private final UUID accountId;
    private final String accountNumber;
    private final String ownerName;
    private final BigDecimal balance;
    private final String status;

    public static BalanceResponse of(Account account, BigDecimal balance) {
        return new BalanceResponse(account, balance);
    }

    private BalanceResponse(Account account, BigDecimal balance) {
        this.accountId     = account.getId();
        this.accountNumber = account.getAccountNumber();
        this.ownerName     = account.getOwnerName();
        this.balance       = balance;
        this.status        = account.getStatus().name();
    }
}