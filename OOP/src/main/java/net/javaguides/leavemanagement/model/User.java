package net.javaguides.leavemanagement.model;

public class User {
    protected int id;
    protected String username;
    protected String password;
    protected String email;
    protected String contactNumber;

    public User() {
    }

    public User(String username, String password, String email, String contactNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public User(int id, String username, String password, String email, String contactNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}