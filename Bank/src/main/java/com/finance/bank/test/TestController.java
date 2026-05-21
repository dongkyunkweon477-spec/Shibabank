package com.finance.bank.test;

import com.finance.bank.exception.CustomException;
import com.finance.bank.exception.ErrorCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    // 케이스 1: CustomException 터뜨리기
    @GetMapping("/user-not-found")
    public String testUserNotFound() {
        throw new CustomException(ErrorCode.USER_NOT_FOUND);
    }

    //HTTP GET 요청 -> 서버 -> Controller -> GetMapping

    // 케이스 2: 서버 에러 터뜨리기
    @GetMapping("/server-error")
    public String testServerError() {
        throw new RuntimeException("예상 못한 에러!");
    }
}