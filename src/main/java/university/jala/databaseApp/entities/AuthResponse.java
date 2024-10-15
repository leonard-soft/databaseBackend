package university.jala.databaseApp.entities;

import java.util.Date;

public class AuthResponse {

    private String token;
    private String name;
    private String lastname;
    private Date birtdate;

    public AuthResponse(String error) {
        this.token = error;
    }

    public AuthResponse(String token, String name, String lastname, Date birthdate) {
        this.token = token;
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
