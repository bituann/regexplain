package com.bituan.regexplain.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class A2AResponse {
    private final String jsonrpc;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String id;
    private Result result;
    private CustomError error;

    public A2AResponse() {
        this.jsonrpc = "2.0";
    }

    public A2AResponse(String id, Result result, CustomError error) {
        this.jsonrpc = "2.0";
        this.id = id;
        this.result = result;
        this.error = error;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public CustomError getError() {
        return error;
    }

    public void setError(CustomError error) {
        this.error = error;
    }
}
