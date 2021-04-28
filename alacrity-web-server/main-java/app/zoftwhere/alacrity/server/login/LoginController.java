package app.zoftwhere.alacrity.server.login;

import app.zoftwhere.alacrity.server.MainConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

import static app.zoftwhere.alacrity.server.AbstractViewController.mapViewResources;
import static org.springframework.http.HttpStatus.OK;

/**
 * Login page controller.
 *
 * @since 1.0.0
 */
@Controller
public class LoginController {

    private final MainConfiguration configuration;

    private final UserDetailsManager manager;

    private final PasswordEncoder encoder;

    /**
     * Login Controller constructor.
     *
     * @param configuration main configuration.
     * @since 1.0.0
     */
    public LoginController(MainConfiguration configuration, UserDetailsManager manager, PasswordEncoder encoder) {
        this.configuration = configuration;
        this.manager = manager;
        this.encoder = encoder;
    }

    /**
     * Login page.
     *
     * @param user  User.
     * @param model Template view model.
     * @return Login page for logged out users, redirect to index page otherwise.
     * @since 1.0.0
     */
    @GetMapping({"/login"})
    public ModelAndView getLogin(Principal user, Model model) {
        if (user == null) {
            // Load login page.
            mapViewResources(configuration, model);
            return new ModelAndView("login");
        }
        else {
            // Redirect user to index page.
            return new ModelAndView("redirect:/", model.asMap());
        }
    }

    /**
     * Login post.
     *
     * @param model Template view model.
     * @return Login state.
     * @since 1.0.0
     */
    @PostMapping({"/login"})
    public ResponseEntity<Boolean> postLogin(@RequestBody LoginForm form, Model model) {
        UserDetails user = manager.loadUserByUsername(form.getUsername());
        if (encoder.matches(form.getPassword(), user.getPassword())) {
            Authentication token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(token);
            return ResponseEntity.status(OK).body(Boolean.TRUE);
        }
        else {
            throw new UsernameNotFoundException("login.controller.error.password.mismatch");
        }
    }

}
