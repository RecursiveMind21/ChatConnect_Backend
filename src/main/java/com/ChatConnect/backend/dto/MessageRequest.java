package com.ChatConnect.backend.dto;

public class MessageRequest {
    private String user_id;
    private String message;

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getUser_id() { return user_id; }
    public void setUser_id(String user_id) { this.user_id = user_id; }

}
