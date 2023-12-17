package com.vs.core.request;

import com.vs.enums.HttpMethods;
import io.restassured.http.ContentType;

import java.util.Map;

public interface IApiRequest {

    String baseUrl();
    String basePath();
    Map<String,Object> pathParams();
    Map<String,Object> queryParams();
    Map<String,String> headers();
    Object requestBody();
    ContentType contentType();
    HttpMethods method();








}
