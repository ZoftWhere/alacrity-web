package app.zoftwhere.alacrity.server.login;

public class LoginForm {

    private String username;

    private String password;

    public LoginForm() {
    }

    public LoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

    @SuppressWarnings("unused")
    public void setUsername(String username) {
        this.username = username;
    }

    String getPassword() {
        return password;
    }

    @SuppressWarnings("unused")
    public void setPassword(String password) {
        this.password = password;
    }

}
