import com.notifications.decorator.EncryptedNotificationDecorator;
import com.notifications.decorator.Notification;
import com.notifications.decorator.SimpleNotification;
import com.notifications.decorator.TimestampedNotificationDecorator;
import com.notifications.observer.LoggingObserver;
import com.notifications.observer.MetricsObserver;

public class TestDecorator {
    
    public static void main(String[] args) {
        System.out.println("=== TEST 1: Notificación Simple (sin decorar) ===\n");
        
        Notification simple = new SimpleNotification("Hola Mundo", "user@test.com");
        simple.addObserver(new LoggingObserver());
        simple.send();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        
        System.out.println("=== TEST 2: Con Timestamp ===\n");
        
        Notification timestamped = new TimestampedNotificationDecorator(
            new SimpleNotification("Mensaje con fecha", "admin@test.com")
        );
        timestamped.addObserver(new LoggingObserver());
        timestamped.send();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        
        System.out.println("=== TEST 3: Con Encriptación ===\n");
        
        Notification encrypted = new EncryptedNotificationDecorator(
            new SimpleNotification("Mensaje secreto", "secure@test.com")
        );
        encrypted.addObserver(new LoggingObserver());
        encrypted.send();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        
        System.out.println("=== TEST 4: Timestamp + Encriptación (COMBINADO) ===\n");
        
        Notification combined = new EncryptedNotificationDecorator(
            new TimestampedNotificationDecorator(
                new SimpleNotification("Mensaje combinado", "vip@test.com")
            )
        );
        combined.addObserver(new LoggingObserver());
        combined.addObserver(new MetricsObserver());
        combined.send();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        MetricsObserver.printStats();
    }
}