package com.jin.web.http;

/**
 * ResponseEntity 사용.
 *  - 현재 사용안함
 * */
public enum ResponseCode {
    SUCCESS(200, "OK"),
    FAIL(500,"ERROR");

    private int statusCode;
    private String msg;

    ResponseCode(int code, String msg) {
        this.statusCode = code;
        this.msg = msg;
    }
}
