package app.zoftwhere.alacrity.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Main application.
 *
 * @since 1.0.0
 */
@SpringBootApplication
@EntityScan(basePackages = "app.zoftwhere.alacrity.server.entity")
public class MainApplication {

    /**
     * Main application method.
     *
     * @param args program arguments
     * @since 1.0.0
     */
    public static void main(String[] args) {
        // Run main application.
        SpringApplication.run(MainApplication.class, args);
    }

}
