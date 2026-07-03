package com.notifications.decorator;

// Clase abstracta base para todos los decoradores

public abstract class NotificationDecorator extends Notification {
    // Envuelve otra notificación
    protected Notification wrappedNotification;
    
    public NotificationDecorator(Notification notification) {
        this.wrappedNotification = notification;
        // Heredar los observadores de la notificación envuelta
        this.observers = notification.observers;
    }
    
    @Override
    public String getRecipient() {
        return wrappedNotification.getRecipient();
    }
    
    @Override
    public void send() {
        wrappedNotification.send();
    }
}