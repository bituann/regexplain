package com.bituan.regexplain.model;

import java.util.Map;

public class CustomError {
    private int code;
    private String message;
    private Map<String, String> data;

    public CustomError(int code, String message, Map<String, String> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
