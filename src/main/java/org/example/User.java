package org.example;

public class User {

    private String idTelegram;
    private String name;

    public User(String idTelegram,
                String name) {
        this.idTelegram = idTelegram;
        this.name = name;
    }

    public String getIdTelegram() {
        return idTelegram;
    }

    public String getName() {
        return name;
    }
}
