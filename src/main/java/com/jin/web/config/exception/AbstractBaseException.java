package com.jin.web.config.exception;

import com.jin.web.http.ResponseCode;
import lombok.Data;

@Data
public abstract class AbstractBaseException extends RuntimeException {

    protected ResponseCode responseCode;
    protected Object[] args;

    public AbstractBaseException() {}

}
