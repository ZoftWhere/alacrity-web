package app.zoftwhere.alacrity.server.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users", schema = "public")
public class User implements Serializable {

    @Id
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Basic
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    public User() {
    }

    public User(String username, String password, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
