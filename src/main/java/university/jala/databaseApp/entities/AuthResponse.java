package university.jala.databaseApp.entities;

import java.util.Date;

public class AuthResponse {

    private String token;
    private int id;
    private String name;
    private String lastname;
    private Date birtdate;

    public AuthResponse(String error) {
        this.token = error;
    }

    public AuthResponse(String token, int id, String name, String lastname, Date birthdate) {
        this.token = token;
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birtdate = birthdate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirtdate() {
        return birtdate;
    }

    public void setBirtdate(Date birtdate) {
        this.birtdate = birtdate;
    }

}
