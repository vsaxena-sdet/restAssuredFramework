package com.vs.core.response;

import com.vs.core.request.IApiRequest;

public interface IApiBuilder<T> {

    T requestSpec(IApiRequest request);
}
