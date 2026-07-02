package com.notifications.factory;

import com.notifications.model.Notification;

public interface NotificationChannel {
    void send(Notification notification);
    String getChannelType();
}