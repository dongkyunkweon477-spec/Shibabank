package com.finance.bank.controller;

import com.finance.bank.dto.request.CreateAccountRequest;
import com.finance.bank.dto.response.CreateAccountResponse;
import com.finance.bank.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
@Tag(name = "Account", description = "계좌 관련 API")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    @Operation(summary = "계좌 개설", description = "신규 계좌를 개설합니다.")
    public ResponseEntity<CreateAccountResponse> createAccount(
            @Valid @RequestBody CreateAccountRequest request) {

        CreateAccountResponse response = accountService.createAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}