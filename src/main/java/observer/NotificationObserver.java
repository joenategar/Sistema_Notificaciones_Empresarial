package main.java.observer;
import main.java.model.NotificationStatus;

// Interface del observador

public interface NotificationObserver {
    void update(String message, NotificationStatus status);
}