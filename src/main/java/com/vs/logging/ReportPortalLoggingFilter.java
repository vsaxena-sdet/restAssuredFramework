package com.vs.logging;


import com.epam.reportportal.service.ReportPortal;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.specification.RequestSpecification;

import java.util.Date;
import java.util.logging.Level;

public class ReportPortalLoggingFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext context) {
        // Attempt to capture the request body from different possible sources
        String requestBody = null;
        if (requestSpec.getBody() != null) {
            requestBody = requestSpec.getBody(); // direct body retrieval
        } else if (!requestSpec.getFormParams().isEmpty()) {
            requestBody = requestSpec.getFormParams().toString(); // form params as body
        } else if (!requestSpec.getRequestParams().isEmpty()) {
            requestBody = requestSpec.getRequestParams().toString(); // query params as body
        } else if (requestSpec.getContentType() != null && requestSpec.getContentType().contains("json")) {
            requestBody = requestSpec.getBody(); // if JSON body is set
        }

        String requestDetails = String.format(
                "Request Method: %s\nURI: %s\nHeaders: %s\nBody: %s",
                requestSpec.getMethod(),
                requestSpec.getURI(),
                requestSpec.getHeaders(),
                requestBody != null ? requestBody : "No Body"
        );
        ReportPortal.emitLog("Logging Request\n" + requestDetails, Level.INFO.getName(), new Date());

        // Proceed with the request and capture the response
        Response response = context.next(requestSpec, responseSpec);

        // Log Response Details
        String responseDetails = String.format(
                "Status Code: %d\nHeaders: %s\nBody: %s",
                response.getStatusCode(),
                response.getHeaders(),
                response.prettyPrint()
        );
        ReportPortal.emitLog("Logging Response\n" + responseDetails, Level.INFO.getName(), new Date());

        return response;
    }
}
