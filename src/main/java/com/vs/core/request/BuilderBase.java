package com.vs.core.request;

import com.vs.core.interfaces.IApiBuilder;
import com.vs.core.interfaces.IApiRequest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class BuilderBase implements IApiBuilder<RequestSpecification> {

    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

    public RequestSpecification requestSpec(IApiRequest request) {

        if (request.baseUrl() != null) {
            requestSpecBuilder.setBaseUri(request.baseUrl());
        }
        if (request.basePath() != null) {
            requestSpecBuilder.setBasePath(request.basePath());
        }
        if (request.queryParams() != null) {
            requestSpecBuilder.addQueryParams(request.queryParams());
        }
        if (request.headers() != null) {
            requestSpecBuilder.addHeaders(request.headers());
        }
        if (request.requestBody() != null) {
            requestSpecBuilder.setBody(request.requestBody());
        }
        if (request.contentType() != null) {
            requestSpecBuilder.setContentType(request.contentType());
        }
        requestSpecBuilder.log(LogDetail.ALL);
        return requestSpecBuilder.build();
    }
}
