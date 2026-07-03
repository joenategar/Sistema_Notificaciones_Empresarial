package com.notifications.model;

public class Notification {
    private String message;
    private String recipient;
    private String priority; // HIGH, MEDIUM, LOW

    public Notification(String message, String recipient, String priority) {
        this.message = message;
        this.recipient = recipient;
        this.priority = priority;
    }

    // Getters
    public String getMessage() { return message; }
    public String getRecipient() { return recipient; }
    public String getPriority() { return priority; }

    @Override
    public String toString() {
        return String.format("Notification[to=%s, priority=%s, message=%s]", 
            recipient, priority, message);
    }
}