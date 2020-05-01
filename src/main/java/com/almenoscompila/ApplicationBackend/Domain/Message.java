package com.almenoscompila.ApplicationBackend.Domain;

import java.util.ArrayList;

public class Message {

    private Chat chat;
    private User sender;
    private String content;

    public Message(Chat chat, User sender, String content) {
        this.chat = chat;
        this.sender = sender;
        this.content = content;
    }

    public Message(MessageBuilder messageBuilder) {
        this.chat = messageBuilder.chat;
        this.sender = messageBuilder.sender;
        this.content = messageBuilder.content;
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

    public static class MessageBuilder {

        public Chat chat;
        public User sender;
        public String content;

        public MessageBuilder() {
        }

        public Message.MessageBuilder chat(Chat chat){
            this.chat= chat;
            return this;
        }

        public Message.MessageBuilder sender(User sender) {
            this.sender = sender;
            return this;
        }

        public Message.MessageBuilder content(String content) {
            this.content = content;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }

}
