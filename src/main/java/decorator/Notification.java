package main.java.decorator;

import main.java.model.NotificationStatus;
import main.java.observer.NotificationObserver;
import java.util.ArrayList;
import java.util.List;

// Clase base Notificación, para que los observadores funcionen

public abstract class Notification {
    
    protected List<NotificationObserver> observers = new ArrayList<>();
    
    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }
    
    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }
    
    protected void notifyObservers(String message, NotificationStatus status) {
        for (NotificationObserver observer : observers) {
            observer.update(message, status);
        }
    }
    
    public abstract String getContent();
    public abstract String getRecipient();
    public abstract void send();
}