package com.almenoscompila.ApplicationBackend.Domain;

import java.awt.*;

public class Chat {

    private User user1;
    private User user2;

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public Chat(ChatBuilder chatBuilder) {
        this.user1 = chatBuilder.user1;
        this.user2 = chatBuilder.user2;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public static class ChatBuilder {

        public User user1, user2;

        public ChatBuilder() {
        }

        public Chat.ChatBuilder user1(User user1){
            this.user1= user1;
            return this;
        }

        public Chat.ChatBuilder user2(User user2){
            this.user2= user2;
            return this;
        }

        public Chat build() {
            return new Chat(this);
        }
    }

}
