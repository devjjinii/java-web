package com.jin.web.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jin.web.dto.BaseCodeEnum;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaseCodeEnumSerializer extends JsonSerializer<BaseCodeEnum> {

    @Override
    public void serialize(BaseCodeEnum baseCodeEnum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("code", baseCodeEnum.code());
        map.put("label", baseCodeEnum.label());
        jsonGenerator.writeObject(map);
    }
}
