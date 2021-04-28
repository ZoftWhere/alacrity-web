package app.zoftwhere.alacrity.server;

import org.springframework.ui.Model;

import java.security.Principal;

public class AbstractViewController {

    /**
     * Method for populating user details.
     *
     * @param user  Principal.
     * @param model Template view model.
     * @since 1.0.0
     */
    public static void mapUserDetails(Principal user, Model model) {
        if (user == null) {
            model.addAttribute("loggedIn", false);
            return;
        }

        model.addAttribute("loggedIn", true);
        model.addAttribute("user", user.getName());
    }

    /**
     * Method for populating parameterized resource string.
     *
     * @param model Template view model.
     * @since 1.0.0
     */
    public static void mapViewResources(MainConfiguration configuration, Model model) {
        model.addAttribute("version", configuration.getAlacrityVersion());
        model.addAttribute("resourceBootstrapCSS", configuration.getResourceBootstrapCSS());
        model.addAttribute("resourceBootstrapJS", configuration.getResourceBootstrapJS());
        model.addAttribute("resourceJQueryJS", configuration.getResourceJQueryJS());
        model.addAttribute("resourceMathJaxJS", configuration.getResourceMathJaxJS());
        model.addAttribute("resourcePopperJS", configuration.getResourcePopperJS());
    }

}
