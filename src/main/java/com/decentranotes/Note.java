package com.decentranotes;

import javax.crypto.SecretKey;

public class Note {
    private String id;
    private String title;
    private String encryptedContent;
    private SecretKey key;

    // Constructor
    public Note(String id, String title, String content) throws Exception {
        this.id = id;
        this.title = title;
        this.key = EncryptionUtil.generateKey();
        this.encryptedContent = EncryptionUtil.encrypt(content, this.key);
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

    @Override
    public String toString() {
        try {
            return "Note{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", content='" + getDecryptedContent() + '\'' +
                    '}';
        } catch (Exception e) {
            e.printStackTrace();
            return "Note{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", content='Error decrypting content'" +
                    '}';
        }
    }
}
