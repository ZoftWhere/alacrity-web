package app.zoftwhere.alacrity.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "authorities", schema = "public")
public class UserAuthority implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @Id
    @Column(name = "authority", nullable = false)
    private String authority;

    public UserAuthority() {
    }

    public UserAuthority(User user, String authority) {
        this.user = user;
        this.authority = authority;
    }

    public User getUsername() {
        return user;
    }

    public void setUsername(User user) {
        this.user = user;
    }

    @SuppressWarnings("unused")
    public String getAuthority() {
        return authority;
    }

    @SuppressWarnings("unused")
    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
