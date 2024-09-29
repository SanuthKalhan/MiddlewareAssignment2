package stl.server.notification.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "notifications")
public class Notification {

    @Id
    private String id;
    private String message;
    private String userId; 
    private boolean isRead;
    private LocalDateTime createdAt;


    public Notification() {
        this.createdAt = LocalDateTime.now();
        this.isRead = false; 
    }

    public Notification(String message, String userId) {
        this.message = message;
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
        this.isRead = false; 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
