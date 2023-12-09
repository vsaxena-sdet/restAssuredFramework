package com.vs.core.response;

import com.vs.core.request.Request;
import io.restassured.response.Response;

public class ApiExecutor extends ApiExecutorBase{

    public ApiExecutor(Request request) {
        super(request);
    }

    @Override
    public Response execute() {
        return super.execute();
    }
}
