package com.craftzn.authserver.config.security;

import com.craftzn.authserver.config.keycloak.KeycloakClientProvider;
import com.craftzn.authserver.config.keycloak.KeycloakClientRegistration;
import com.craftzn.authserver.config.keycloak.KeycloakLogoutHandler;
import com.craftzn.authserver.config.keycloak.ResourceServer;
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
    KeycloakClientRegistration keycloakClientRegistration;

    @Autowired
    KeycloakClientProvider keycloakClientProvider;

    @Autowired
    ResourceServer resourceServer;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v1/notifications**")
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

    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    protected JwtDecoder jwtDecoder() {
        return JwtDecoders.fromIssuerLocation(keycloakClientProvider.getIssuerUri());
    }
}