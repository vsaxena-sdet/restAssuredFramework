package com.vs.helpers.restHelper;

import com.vs.core.request.Request;
import com.vs.enums.HttpMethods;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

public class RequestHelper {

    public Request getUsersRequest() {
        Request request = new Request();
        Map<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put("page", 1);
        request.baseURI = "https://reqres.in/";
        request.path = "api/users";
        request.queryParams = queryParams;
        request.method = HttpMethods.GET;
        request.contentType = ContentType.JSON;
        request.headers = Map.of("x-api-key","reqres-free-v1");
        return request;
    }

    public Request createPetStoreUserRequest(String body){
        Request request = new Request();
        request.baseURI = "https://petstore.swagger.io";
        request.path = "/v2/user";
        request.method = HttpMethods.POST;
        request.body=body;
        request.contentType = ContentType.JSON;
        return request;
    }
}
