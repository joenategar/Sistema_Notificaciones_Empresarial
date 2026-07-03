package com.notifications.strategy;

import com.notifications.factory.NotificationChannel;
import com.notifications.model.Notification;

public class BatchDeliveryStrategy implements DeliveryStrategy {
    
    @Override
    public void deliver(Notification notification, NotificationChannel channel) {
        System.out.println("Estrategia:ENVÍO POR LOTES");
        System.out.println("La notificación se agregará al siguiente lote (cada 5 min)");
        System.out.println("Prioridad: " + notification.getPriority());
        
        // Simulación de espera
        System.out.println("Esperando a completar lote...");
        channel.send(notification);
    }

    @Override
    public String getStrategyName() {
        return "BATCH";
    }
}