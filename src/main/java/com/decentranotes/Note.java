package com.decentranotes;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;

public class Note {
    private String id;
    private String title;
    private String encryptedContent;
    private SecretKey key;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructor
    public Note(String id, String title, String content) throws Exception {
        this.id = id;
        this.title = title;
        this.key = EncryptionUtil.generateKey();
        this.encryptedContent = EncryptionUtil.encrypt(content, this.key);
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    // Method to update content
    public void updateContent(String content) throws Exception {
        this.encryptedContent = EncryptionUtil.encrypt(content, this.key);
        this.updatedAt = LocalDateTime.now();
    }

    // Method to get decrypted content
    public String getDecryptedContent() throws Exception {
        return EncryptionUtil.decrypt(encryptedContent, key);
    }

    // Other getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        try {
            return "Note{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", content='" + getDecryptedContent() + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    '}';
        } catch (Exception e) {
            e.printStackTrace();
            return "Note{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", content='Error decrypting content'" +
                    ", createdAt='" + createdAt + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    '}';
        }
    }
}
