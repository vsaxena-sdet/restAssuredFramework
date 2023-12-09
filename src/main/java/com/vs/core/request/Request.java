package com.vs.core.request;

import com.vs.enums.HttpMethods;
import com.vs.core.interfaces.IApiRequest;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class Request implements IApiRequest {

    public String baseURI;
    public String path;
    public HttpMethods method;
    public Map<String, String> headers;
    public Map<String, Object> queryParams;
    public Map<String, Object> pathParams;
    public String contentType;
    public String body;

    @Override
    public String baseUrl() {
        return this.baseURI;
    }

    @Override
    public String basePath() {
        return this.path;
    }

    @Override
    public Map<String, Object> pathParams() {
        return this.pathParams;
    }

    @Override
    public Map<String, Object> queryParams() {
        return this.queryParams;
    }

    @Override
    public Map<String, String> headers() {
        return this.headers;
    }

    @Override
    public Object requestBody() {
        return this.body;
    }

    @Override
    public String contentType() {
        return this.contentType;
    }

    @Override
    public HttpMethods method() {
        return this.method;
    }
}
