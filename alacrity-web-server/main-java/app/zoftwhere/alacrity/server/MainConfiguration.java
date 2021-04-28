package app.zoftwhere.alacrity.server;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Main configuration.
 *
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("alacrity")
public class MainConfiguration {

    private String alacrityVersion;

    private String resourceBootstrapCSS;

    private String resourceBootstrapJS;

    private String resourceJQueryJS;

    private String resourceMathJaxJS;

    private String resourcePopperJS;

    /**
     * Get the Alacrity version.
     *
     * @return Alacrity version.
     * @since 1.0.0
     */
    public String getAlacrityVersion() {
        return alacrityVersion;
    }

    /**
     * Set the Alacrity version.
     *
     * @param alacrityVersion Alacrity version.
     * @since 1.0.0
     */
    @SuppressWarnings("unused")
    public void setAlacrityVersion(String alacrityVersion) {
        this.alacrityVersion = alacrityVersion;
    }

    /**
     * Get the Bootstrap resource URL.
     *
     * @return Bootstrap CSS resource URL.
     * @since 1.0.0
     */
    public String getResourceBootstrapCSS() {
        return resourceBootstrapCSS;
    }

    /**
     * Set the Bootstrap resource URL.
     *
     * @param url Bootstrap CSS resource URL.
     * @since 1.0.0
     */
    @SuppressWarnings("unused")
    public void setResourceBootstrapCSS(String url) {
        this.resourceBootstrapCSS = url;
    }

    /**
     * Get the Bootstrap JS resource URL.
     *
     * @return Bootstrap JS resource URL.
     * @since 1.0.0
     */
    public String getResourceBootstrapJS() {
        return resourceBootstrapJS;
    }

    /**
     * Set the Bootstrap JS resource URL.
     *
     * @param url Bootstrap JS resource URL.
     * @since 1.0.0
     */
    @SuppressWarnings("unused")
    public void setResourceBootstrapJS(String url) {
        this.resourceBootstrapJS = url;
    }

    /**
     * Get the JQuery JS resource URL.
     *
     * @return JQuery JS resource URL.
     * @since 1.0.0
     */
    public String getResourceJQueryJS() {
        return resourceJQueryJS;
    }

    /**
     * Set the JQuery JS resource URL.
     *
     * @param url JQuery JS resource URL.
     * @since 1.0.0
     */
    @SuppressWarnings("unused")
    public void setResourceJQueryJS(String url) {
        this.resourceJQueryJS = url;
    }

    /**
     * Get the MathJax JS resource URL.
     *
     * @return MathJax JS resource URL.
     * @since 1.0.0
     */
    public String getResourceMathJaxJS() {
        return resourceMathJaxJS;
    }

    /**
     * Set the MathJax JS resource URL.
     *
     * @param url MathJax JS resource URL.
     * @since 1.0.0
     */
    @SuppressWarnings("unused")
    public void setResourceMathJaxJS(String url) {
        this.resourceMathJaxJS = url;
    }

    /**
     * Get the Popper JS resource URL.
     *
     * @return Popper JS resource URL.
     * @since 1.0.0
     */
    public String getResourcePopperJS() {
        return resourcePopperJS;
    }

    /**
     * Set the Popper JS resource URL.
     *
     * @param url Popper JS resource URL.
     * @since 1.0.0
     */
    @SuppressWarnings("unused")
    public void setResourcePopperJS(String url) {
        this.resourcePopperJS = url;
    }

}
