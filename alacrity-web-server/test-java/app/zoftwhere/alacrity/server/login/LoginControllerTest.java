package app.zoftwhere.alacrity.server.login;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@TestInstance(value = PER_CLASS)
class LoginControllerTest {

    @Autowired
    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    private UserDetailsManager manager;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    private PasswordEncoder encoder;

    @LocalServerPort
    private int serverPort;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    private LoginController controller;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    private TestRestTemplate restTemplate;

    @BeforeAll
    void setupLoginController() {
        final String username = "register@LoginControllerTest.java";
        final String password = "password";
        final String[] roles = new String[]{"USER", "ADMIN"};

        UserDetails user = User.builder()
            .username(username)
            .password(encoder.encode(password))
            .roles(roles)
            .build();

        manager.deleteUser(username);
        manager.createUser(user);
    }

    @Test
    void testWiring() {
        final String localhost = "http://localhost:" + serverPort;
        assertThat(controller).isNotNull();
        assertThat(restTemplate.getForObject(localhost + "/login", String.class)).isNotNull();
        assertThat(restTemplate.getForObject(localhost + "/logout", String.class)).isNotNull();
    }

    @Test
    void defaultUser() {
        final String username = "osmund.francis@test.com";
        final String password = encoder.encode("password");
        final String[] roles = new String[]{"USER"};
        registerUser(username, password, roles);
    }

    @Test
    void jdbcUserDetailsManager() {
        final String username = "register-user@LoginControllerTest.jdbcUserDetailsManager.com";
        final String password = encoder.encode("password");
        final String[] roles = new String[]{"USER"};
        registerUser(username, password, roles);
    }

    @SuppressWarnings("SameParameterValue")
    void registerUser(String username, String password, String[] roles) {
        UserDetails user = User.builder()
            .username(username)
            .password(password)
            .roles(roles)
            .build();
        manager.deleteUser(username);
        manager.createUser(user);
    }

}
