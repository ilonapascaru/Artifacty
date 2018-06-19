package clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
public class User {
   private String username;
   private String password;
   private int id_user;
   private String grupuri_interes;
   private String tip_utilizator;
   private String email;

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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getGrupuri_interes() {
        return grupuri_interes;
    }

    public void setGrupuri_interes(String grupuri_interes) {
        this.grupuri_interes = grupuri_interes;
    }

    public String getTip_utilizator() {
        return tip_utilizator;
    }

    public void setTip_utilizator(String tip_utilizator) {
        this.tip_utilizator = tip_utilizator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
