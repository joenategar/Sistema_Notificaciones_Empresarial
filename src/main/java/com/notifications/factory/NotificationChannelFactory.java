package com.notifications.factory;

import com.notifications.channels.*;

public class NotificationChannelFactory {
    
    public static NotificationChannel createChannel(String type) {
        return switch (type.toLowerCase()) {
            case "email" -> new EmailChannel();
            case "sms" -> new SMSChannel();
            case "push" -> new PushChannel();
            default -> throw new IllegalArgumentException("Canal no soportado: " + type);
        };
    }
}