package com.bituan.regexplain.model;

public class A2ARequest {
    private String id;
    private RequestParamsProperty params;

    public A2ARequest(String id, RequestParamsProperty params) {
        this.id = id;
        this.params = params;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RequestParamsProperty getParams() {
        return params;
    }

    public void setParams(RequestParamsProperty params) {
        this.params = params;
    }
}

