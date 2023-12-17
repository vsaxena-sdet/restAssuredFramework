package com.vs.helpers.restHelper;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonHelper {

    private static final Logger logger = LoggerFactory.getLogger(JsonHelper.class);

    public static <T> T parseJsonResponse(Response jsonResponse, Class<T> pojoClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonResponse.asString(), pojoClass);
        } catch (Exception e) {
            logger.error("exception occurred when parsing json response ", e);
            return null;
        }
    }
}
