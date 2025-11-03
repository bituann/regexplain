package com.bituan.regexplain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessagePart {
    private String kind;
    private String text;
    private List<MessagePart> data;

    public MessagePart(String kind, String text, List<MessagePart> data) {
        this.kind = kind;
        this.text = text;
        this.data = data;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<MessagePart> getData() {
        return data;
    }

    public void setData(List<MessagePart> data) {
        this.data = data;
    }
}
