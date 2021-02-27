package com.jin.web.http;

import lombok.Data;

/**
 * ResponseEntity 가 아닌
 * 생성한 API 공통 규격
 * */
@Data
public class Response<T> {
    private ResponseCode code;
    private String message;
    private T data;

    public Response(T data) {
        this.code = ResponseCode.SUCCESS;
        this.data = data;
    }

    public Response(ResponseCode code, String message) {
        this.code = code;
        this.message = message;
    }
}
