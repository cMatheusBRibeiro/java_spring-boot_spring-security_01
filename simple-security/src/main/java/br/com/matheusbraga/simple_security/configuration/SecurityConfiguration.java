package br.com.matheusbraga.simple_security.configuration;

import br.com.matheusbraga.simple_security.service.MyUserDetailService;
import br.com.matheusbraga.simple_security.support.encoder.PlainTextPasswordEncorder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final MyUserDetailService myUserDetailService;

    public SecurityConfiguration(MyUserDetailService myUserDetailService) {
        this.myUserDetailService = myUserDetailService;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PlainTextPasswordEncorder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(myUserDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests -> {
            authorizeRequests.requestMatchers("/public").permitAll();
            authorizeRequests.requestMatchers("/logout").permitAll();
            authorizeRequests.anyRequest().authenticated();
        });
        http.formLogin(Customizer.withDefaults());
        return http.build();
    }

}
