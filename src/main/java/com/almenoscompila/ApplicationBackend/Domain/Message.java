package com.almenoscompila.ApplicationBackend.Domain;

public class Message {

    private Chat chat;
    private User sender;
    private String content;

    public Message(Chat chat, User sender, String content) {
        this.chat = chat;
        this.sender = sender;
        this.content = content;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
