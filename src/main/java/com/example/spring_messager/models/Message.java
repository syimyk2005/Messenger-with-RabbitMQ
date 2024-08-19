package com.example.spring_messager.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "\"message\"")
    public class Message {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "sender_id", nullable = false)
        private User sender;

        @ManyToOne
        @JoinColumn(name = "recipient_id", nullable = false)
        private User recipient;

        private String content;
        private LocalDateTime timestamp;

        // Getters and Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public User getSender() {
            return sender;
        }

        public void setSender(User sender) {
            this.sender = sender;
        }

        public User getRecipient() {
            return recipient;
        }

        public void setRecipient(User recipient) {
            this.recipient = recipient;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }
    }


