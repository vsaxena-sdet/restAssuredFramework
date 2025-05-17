package com.vs.core.response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.reportportal.service.ReportPortal;
import com.vs.core.request.BuilderBase;
import com.vs.core.request.Request;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Date;
import java.util.logging.Level;

public abstract class ApiExecutorBase extends BuilderBase implements IApiResponse {

    Request request;
    private static final Logger logger = LogManager.getLogger(ApiExecutorBase.class);

    public ApiExecutorBase(Request request) {
        this.request = request;
    }

    @Override
    public Response execute() {
        RequestSpecification spec = requestSpec(request);
        RestAssuredConfig config = RestAssured.config;
        Response response;
        switch (request.method()) {
            case GET:
                logger.info("Executing GET request to: " + request.baseURI + request.path);
                response = RestAssured.given().config(config).spec(spec).get();
                break;
            case POST:
                logger.info("Executing POST request to: " + request.baseURI + request.path);
                logger.info("Request Body: " + request.body);
                response = RestAssured.given().filter(new RequestLoggingFilter()).config(config).spec(spec).body(request.body).post(request.baseURI.concat(request.path));
                break;
            case PUT:
                logger.info("Executing PUT request to: " + request.baseURI + request.path);
                response = RestAssured.given().config(config).spec(spec).put();
                break;
            default:
                throw new RuntimeException("Method cannot be empty");
        }
        String responseBody = response.prettyPrint();
        logger.info("Response Status Code: " + response.getStatusCode());
        logger.info("Response Body: " + responseBody);
        return response;
    }
}
