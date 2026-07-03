package com.notifications.decorator;

import com.notifications.model.NotificationStatus;

public class SimpleNotification extends Notification {
    
    private String content;
    private String recipient;
    
    public SimpleNotification(String content, String recipient) {
        this.content = content;
        this.recipient = recipient;
    }
    
    @Override
    public String getContent() {
        return content;
    }
    
    @Override
    public String getRecipient() {
        return recipient;
    }
    
    @Override
    public void send() {
        System.out.println("Sending notification to: " + recipient);
        System.out.println("Content: " + getContent());
        notifyObservers(getContent(), NotificationStatus.SENT);
    }
}