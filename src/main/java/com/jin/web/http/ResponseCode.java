package com.jin.web.http;

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
