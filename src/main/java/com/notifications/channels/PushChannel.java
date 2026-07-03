package com.notifications.channels;

import com.notifications.factory.NotificationChannel;
import com.notifications.model.Notification;

public class PushChannel implements NotificationChannel {
    
    @Override
    public void send(Notification notification) {
        System.out.println("Enviando Push Notification...");
        System.out.println("   Usuario: " + notification.getRecipient());
        System.out.println("   Alerta: " + notification.getMessage());
        System.out.println("    Push enviado exitosamente\n");
    }

    @Override
    public String getChannelType() {
        return "PUSH";
    }
}