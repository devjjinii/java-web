package com.jin.web.http;

/**
 * ResponseEntity 사용.
 *  - 현재 사용안함
 * */
public enum ResponseCode {
//    SUCCESS(200),
    SUCCESS,
    FAIL,
    DATA_IS_NULL, // NULL 체크
    VALIDATE_CHECK,  // 필수값 확인
    ;


/*
* CODE 생략
* */
//    private int status;
//
//    ResponseCode(int status) {
//        this.status = status;
//    }
//
//    public int status() {
//        return status;
//    }
}
