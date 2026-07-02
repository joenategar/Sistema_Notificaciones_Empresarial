package main.java.observer;


import main.java.model.NotificationStatus;

public class MetricsObserver implements NotificationObserver {
    
    private static int sentCount = 0; // enviadas
    private static int failedCount = 0; // fallidas
    
    @Override
    public void update(String message, NotificationStatus status) {
        if (status == NotificationStatus.SENT) {
            sentCount++;
        } else if (status == NotificationStatus.FAILED) {
            failedCount++;
        }
        System.out.println("[METRICS] Current stats -> Sent: " + sentCount + ", Failed: " + failedCount);
    }
    // Estadísticas finales
    public static void printStats() {
        System.out.println("\n=== FINAL METRICS ===");
        System.out.println("Total Sent: " + sentCount);
        System.out.println("Total Failed: " + failedCount);
        System.out.println("Total Notifications: " + (sentCount + failedCount));
        System.out.println("=====================\n");
    }
    
    public static void reset() {
        sentCount = 0;
        failedCount = 0;
    }
}