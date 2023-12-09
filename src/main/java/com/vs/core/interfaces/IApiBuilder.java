package com.vs.core.interfaces;

import io.restassured.specification.RequestSpecification;

public interface IApiBuilder<T> {

    T requestSpec(IApiRequest request);
}
