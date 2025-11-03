package com.bituan.regexplain.model;

class RequestParamsProperty {
    private HistoryMessage message;
    private String messageId;

    public RequestParamsProperty(HistoryMessage message, String messageId) {
        this.message = message;
        this.messageId = messageId;
    }

    public HistoryMessage getMessage() {
        return message;
    }

    public void setMessage(HistoryMessage message) {
        this.message = message;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
