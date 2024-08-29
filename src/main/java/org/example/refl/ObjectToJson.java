package org.example.refl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.HashMap;
import java.util.Map;

public class ObjectToJson {

    public String transform(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Map<String, Object> mapper = new HashMap<String, Object>();

        return null;
    }
}
