package app.zoftwhere.alacrity.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    public SecurityConfiguration() {
    }

    /**
     * Method for configuring authentication to a datasource and password encoder.
     *
     * @param builder Authentication manager builder.
     * @throws Exception Throws exception when builder fails.
     */
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public void configAuthentication(AuthenticationManagerBuilder builder, DataSource dataSource) throws Exception {
        builder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
    }

    /**
     * Password encoder bean.
     *
     * @return Password encoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * User detail manager bean.
     *
     * @return User detail manager.
     */
    @Bean
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
        manager.setDataSource(dataSource);
        return manager;
    }

    /**
     * Configure security configuration.
     *
     * @param security HTTP security.
     * @throws Exception Throws exception when security configuration fails.
     */
    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.csrf().disable()
            .authorizeRequests()
            .antMatchers("/", "/public/*", "/favicons/*")
            .permitAll()
            .antMatchers("/index", "/home", "/login")
            .permitAll()
            .antMatchers("/application.yaml", "/templates/*")
            .hasRole("ADMIN")
            .anyRequest().authenticated();
    }

}
