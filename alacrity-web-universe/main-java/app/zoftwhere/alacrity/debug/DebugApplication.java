package app.zoftwhere.alacrity.debug;

import app.zoftwhere.alacrity.server.MainApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * Debug application.
 *
 * @since 1.0.0
 */
public class DebugApplication extends MainApplication {

    /**
     * Debug application main method.
     *
     * @param args program arguments
     * @since 1.0.0
     */
    public static void main(String[] args) {
        // Run debug application.
        SpringApplication.run(DebugApplication.class, args);
    }

    /**
     * Debug application actions at start up.
     *
     * @param manager User details manager for registering new users.
     * @param encoder Password encoder for securing passwords.
     * @since 1.0.0
     */
    @Autowired
    public void startUp(UserDetailsManager manager, PasswordEncoder encoder) {
        registerAdmin(manager, "admin@email.com", encoder.encode("password"));
        registerUser(manager, "user@email.com", encoder.encode("password"));
    }

    /**
     * Private helper method for registering admin users.
     *
     * @param manager  User details manager for registering new admins.
     * @param username Username.
     * @param password Encoded password.
     * @since 1.0.0
     */
    @SuppressWarnings("SameParameterValue")
    private void registerAdmin(UserDetailsManager manager, String username, String password) {
        UserDetails user = User.builder().username(username).password(password).roles("ADMIN", "USER").build();
        manager.deleteUser(username);
        manager.createUser(user);
    }

    /**
     * Private helper method for registering standard users.
     *
     * @param manager  User details manager for registering new admins.
     * @param username Username.
     * @param password Encoded password.
     * @since 1.0.0
     */
    @SuppressWarnings("SameParameterValue")
    private void registerUser(UserDetailsManager manager, String username, String password) {
        UserDetails user = User.builder().username(username).password(password).roles("USER").build();
        manager.deleteUser(username);
        manager.createUser(user);
    }

}
