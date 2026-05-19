

package com.finance.bank.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {

    private final int status;           // 404, 400, 500 ...
    private final String code;          // "USER_NOT_FOUND"
    private final String message;       // "유저를 찾을 수 없습니다."
    private final LocalDateTime timestamp;

    // CustomException 으로 만들 때
    public ErrorResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus().value();
        this.code = errorCode.name();
        this.message = errorCode.getMessage();
        this.timestamp = LocalDateTime.now();
    }

    // 예상 못한 서버 에러일 때
    public ErrorResponse(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}