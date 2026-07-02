package main.java.decorator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampedNotificationDecorator extends NotificationDecorator {
    
    private static final DateTimeFormatter formatter = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public TimestampedNotificationDecorator(Notification notification) {
        super(notification);
    }
    // Añade fecha y hora al contenido de la notificación
    @Override
    public String getContent() {
        String timestamp = LocalDateTime.now().format(formatter);
        return "[" + timestamp + "] " + wrappedNotification.getContent();
    }
    // Mensaje para avisar q se añade
    @Override
    public void send() {
        System.out.println("[TIMESTAMPED] Adding timestamp...");
        super.send();
    }
}