package com.craftzn.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Autowired
    KeycloakLogoutHandler keycloakLogoutHandler;

    @Autowired
    KeycloakClientProvider keycloakClientProvider;

    @Autowired
    KeycloakClientRegistration keycloakClientRegistration;

    @Autowired
    KeycloakResourceServer keycloakResourceServer;

    SecurityConfig(
            KeycloakLogoutHandler keycloakLogoutHandler,
            KeycloakClientProvider keycloakClientProvider,
            KeycloakClientRegistration keycloakClientRegistration,
            KeycloakResourceServer keycloakResourceServer
    ) {
        this.keycloakLogoutHandler = keycloakLogoutHandler;
        this.keycloakClientProvider = keycloakClientProvider;
        this.keycloakClientRegistration = keycloakClientRegistration;
        this.keycloakResourceServer = keycloakResourceServer;
    }

    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return JwtDecoders.fromIssuerLocation(keycloakResourceServer.getIssuerUri());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v1/users**")
                .hasRole("USER")
                .anyRequest()
                .authenticated();
        http.oauth2Login()
                .and()
                .logout()
                .addLogoutHandler(keycloakLogoutHandler)
                .logoutSuccessUrl("/v1/logout");
        http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
        return http.build();
    }
}