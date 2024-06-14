package net.javaguides.leavemanagement.model;

public class Leave {
    protected int id;
    protected String name;
    protected String status;
    protected String type;

    public Leave() {
    }

    public Leave(String name, String status, String type) {
        super();
        this.name = name;
        this.status = status;
        this.type = type;
    }

    public Leave(int id, String name, String status, String type) {
        super();
        this.id = id;
        this.name = name;
        this.status = status;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}