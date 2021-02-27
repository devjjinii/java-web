package com.jin.web.config.exception;

import com.jin.web.http.ResponseCode;

public class BaseException extends AbstractBaseException{

    public BaseException() {}

    public BaseException(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public BaseException(ResponseCode responseCode, String[] args) {
        this.responseCode = responseCode;
        this.args = args;
    }
}
