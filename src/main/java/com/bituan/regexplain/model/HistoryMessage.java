package com.bituan.regexplain.model;

import java.util.List;
import java.util.Map;

public class HistoryMessage {
    private String kind;
    private String role;
    private List<Map<String, Object>> parts;
    private String messageId;
    private String taskId;

    public HistoryMessage(String role, List<Map<String, Object>> parts, String messageId, String taskId) {
        this.kind = "message";
        this.role = role;
        this.parts = parts;
        this.messageId = messageId;
        this.taskId = taskId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Map<String, Object>> getParts() {
        return parts;
    }

    public void setParts(List<Map<String, Object>> parts) {
        this.parts = parts;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
