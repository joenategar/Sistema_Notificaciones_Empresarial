package main.java.decorator;

import java.util.Base64;

public class EncryptedNotificationDecorator extends NotificationDecorator {
    
    public EncryptedNotificationDecorator(Notification notification) {
        super(notification);
    }
    // Toma el contenido original
    @Override
    public String getContent() {
        String originalContent = wrappedNotification.getContent();
        // Simulamos encriptación con Base64
        return Base64.getEncoder().encodeToString(originalContent.getBytes());
    }
    // mensaje para simular la encriptación
    @Override
    public void send() {
        System.out.println("[ENCRYPTED] Encrypting content...");
        super.send();
    }
}