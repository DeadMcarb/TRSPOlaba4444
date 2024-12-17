package org.example.trspolaba4;

public class User {
    private final int id;
    private final String name;
    private final String password;
    private final String roles;
    private final String email;


    public User(int id, String name, String password, String roles, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roles = roles;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRoles() {
        return roles;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return id + " | "  + name;
    }

}
