package com.vs.core.interfaces;

import com.vs.core.response.ApiExecutor;
import io.restassured.response.Response;

public interface IApiResponse {
    Response execute();
}
