package com.notifications.strategy;

import com.notifications.factory.NotificationChannel;
import com.notifications.model.Notification;

public interface DeliveryStrategy {
    void deliver(Notification notification, NotificationChannel channel);
    String getStrategyName();
}