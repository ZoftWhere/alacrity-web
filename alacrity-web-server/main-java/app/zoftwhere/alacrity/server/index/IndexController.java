package app.zoftwhere.alacrity.server.index;

import app.zoftwhere.alacrity.server.MainConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

import static app.zoftwhere.alacrity.server.AbstractViewController.mapUserDetails;
import static app.zoftwhere.alacrity.server.AbstractViewController.mapViewResources;

/**
 * Index page controller.
 *
 * @since 1.0.0
 */
@Controller
public class IndexController {

    private final MainConfiguration configuration;

    /**
     * Index Controller constructor.
     *
     * @param configuration main configuration.
     */
    public IndexController(MainConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * Index page.
     *
     * @param model Template view model.
     * @return template name.
     * @since 1.0.0
     */
    @GetMapping({"/", "/index", "/home"})
    public String getIndexPage(Principal user, Model model) {
        mapUserDetails(user, model);
        mapViewResources(configuration, model);
        return "index";
    }

}
