package com.notifications.channels;

import com.notifications.factory.NotificationChannel;
import com.notifications.model.Notification;

public class EmailChannel implements NotificationChannel {
    
    @Override
    public void send(Notification notification) {
        System.out.println("Enviando Email...");
        System.out.println("   Para: " + notification.getRecipient());
        System.out.println("   Mensaje: " + notification.getMessage());
        System.out.println("    Email enviado exitosamente\n");
    }

    @Override
    public String getChannelType() {
        return "EMAIL";
    }
}