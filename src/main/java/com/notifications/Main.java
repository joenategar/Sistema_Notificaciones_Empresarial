package com.notifications;

import com.notifications.factory.*;
import com.notifications.model.Notification;
import com.notifications.strategy.*;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE NOTIFICACIONES ===\n");
        
        // Crear notificaciones
        Notification urgentNotif = new Notification(
            "El servidor está caído", 
            "admin@empresa.com", 
            "HIGH"
        );
        
        Notification regularNotif = new Notification(
            "Nuevo mensaje en tu bandeja", 
            "+52 555-1234", 
            "MEDIUM"
        );
        
        Notification promoNotif = new Notification(
            "¡50% de descuento hoy!", 
            "user123", 
            "LOW"
        );
        
        // DEMOSTRACIÓN FACTORY METHOD
        System.out.println("--- FACTORY METHOD: Crear canales ---\n");
        
        NotificationChannel emailChannel = NotificationChannelFactory.createChannel("email");
        NotificationChannel smsChannel = NotificationChannelFactory.createChannel("sms");
        NotificationChannel pushChannel = NotificationChannelFactory.createChannel("push");
        
        System.out.println("✓ Canales creados: " + emailChannel.getChannelType() + 
                          ", " + smsChannel.getChannelType() + 
                          ", " + pushChannel.getChannelType() + "\n");
        
        // DEMOSTRACIÓN STRATEGY
        System.out.println("--- STRATEGY: Estrategias de envío ---\n");
        
        DeliveryStrategy immediateStrategy = new ImmediateDeliveryStrategy();
        DeliveryStrategy batchStrategy = new BatchDeliveryStrategy();
        
        // Caso 1: Notificación urgente por email (inmediato)
        System.out.println(" CASO 1: Alerta urgente");
        immediateStrategy.deliver(urgentNotif, emailChannel);
        
        // Caso 2: Notificación regular por SMS (inmediato)
        System.out.println(" CASO 2: Mensaje regular");
        immediateStrategy.deliver(regularNotif, smsChannel);
        
        // Caso 3: Promoción por push (por lotes)
        System.out.println(" CASO 3: Promoción");
        batchStrategy.deliver(promoNotif, pushChannel);
        
        System.out.println("=== FIN DE LA DEMOSTRACIÓN ===");
    }
}