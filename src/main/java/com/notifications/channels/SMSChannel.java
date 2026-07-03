package com.notifications.channels;

import com.notifications.factory.NotificationChannel;
import com.notifications.model.Notification;

public class SMSChannel implements NotificationChannel {
    
    @Override
    public void send(Notification notification) {
        System.out.println("Enviando SMS...");
        System.out.println("   Número: " + notification.getRecipient());
        System.out.println("   Texto: " + notification.getMessage());
        System.out.println("    SMS enviado exitosamente\n");
    }

    @Override
    public String getChannelType() {
        return "SMS";
    }
}