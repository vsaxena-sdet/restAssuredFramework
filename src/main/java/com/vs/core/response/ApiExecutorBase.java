package com.vs.core.response;

import com.vs.core.request.BuilderBase;
import com.vs.core.request.Request;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class ApiExecutorBase extends BuilderBase implements IApiResponse {

    Request request;

    public ApiExecutorBase(Request request) {
        this.request = request;
    }

    @Override
    public Response execute() {
        RequestSpecification spec = requestSpec(request);
        RestAssuredConfig config = RestAssured.config;
        Response  response;

        switch (request.method()){
            case GET:
                response = RestAssured.given().when().config(config).spec(spec).get();
                break;
            case POST:
                response = RestAssured.given().when().config(config).spec(spec).post();
                break;
            default:
                throw  new RuntimeException("Method cannot be empty");
        }

        return response;
    }
}
