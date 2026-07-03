package com.notifications.observer;
import main.java.com.notifications.model.NotificationStatus;

// Interface del observador

public interface NotificationObserver {
    void update(String message, NotificationStatus status);
}