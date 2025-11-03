package com.bituan.regexplain.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskStatus {
    private String state;
    private Instant timestamp;
    private HistoryMessage message;

    public TaskStatus() {}

    public TaskStatus(String state, Instant timestamp, HistoryMessage message) {
        this.state = state;
        this.timestamp = timestamp;
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public HistoryMessage getMessage() {
        return message;
    }

    public void setMessage(HistoryMessage message) {
        this.message = message;
    }
}
