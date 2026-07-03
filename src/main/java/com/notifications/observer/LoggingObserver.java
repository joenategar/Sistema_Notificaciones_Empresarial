package main.java.com.notifications.observer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import main.java.com.notifications.model.NotificationStatus;

public class LoggingObserver implements NotificationObserver {
    
    private static final DateTimeFormatter formatter = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // Fecha, estado, mensaje
    @Override
    public void update(String message, NotificationStatus status) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[LOG] " + timestamp + " - Status: " + status + " - Message: " + message);
    }
}
