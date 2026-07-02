package main.java;

import main.java.decorator.Notification;
import main.java.model.NotificationStatus;
import main.java.observer.LoggingObserver;
import main.java.observer.MetricsObserver;

public class TestObserver {
    
    public static void main(String[] args) {
        // Creamos una notificación simple de prueba
        Notification notification = new SimpleTestNotification("Hola Mundo", "test@email.com");
        
        // Añadimos los observadores
        notification.addObserver(new LoggingObserver());
        notification.addObserver(new MetricsObserver());
        
        // Simulamos envíos
        System.out.println("=== Enviando notificaciones de prueba ===\n");
        notification.send(); // Exitosa
        notification.send(); // Exitosa
        
        // Simulamos una falla
        Notification failedNotification = new SimpleTestNotification("Mensaje con error", "invalid@");
        failedNotification.addObserver(new LoggingObserver());
        failedNotification.addObserver(new MetricsObserver());
        ((SimpleTestNotification) failedNotification).setWillFail(true);
        failedNotification.send(); // Fallida
        
        // Mostramos métricas finales
        MetricsObserver.printStats();
    }
}

// Clase auxiliar temporal solo para la prueba
class SimpleTestNotification extends Notification {
    private String content;
    private String recipient;
    private boolean willFail = false;
    
    public SimpleTestNotification(String content, String recipient) {
        this.content = content;
        this.recipient = recipient;
    }
    
    public void setWillFail(boolean willFail) {
        this.willFail = willFail;
    }
    
    @Override
    public String getContent() {
        return content;
    }
    
    @Override
    public String getRecipient() {
        return recipient;
    }
    
    @Override
    public void send() {
        if (willFail) {
            System.out.println("Intentando enviar a: " + recipient + " -> ERROR\n");
            notifyObservers(content, NotificationStatus.FAILED);
        } else {
            System.out.println("Enviando a: " + recipient + " -> SUCCESS\n");
            notifyObservers(content, NotificationStatus.SENT);
        }
    }
}