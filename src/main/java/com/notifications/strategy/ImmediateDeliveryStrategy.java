package com.notifications.strategy;

import com.notifications.factory.NotificationChannel;
import com.notifications.model.Notification;

public class ImmediateDeliveryStrategy implements DeliveryStrategy {
    
    @Override
    public void deliver(Notification notification, NotificationChannel channel) {
        System.out.println("⚡ Estrategia: ENVÍO INMEDIATO");
        System.out.println("Prioridad: " + notification.getPriority());
        channel.send(notification);
    }

    @Override
    public String getStrategyName() {
        return "IMMEDIATE";
    }
}