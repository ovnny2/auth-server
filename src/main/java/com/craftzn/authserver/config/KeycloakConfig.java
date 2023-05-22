package com.craftzn.authserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    @Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.keycloak.client-name}")
    private String clientName;

    @Value("${spring.security.oauth2.client.registration.keycloak.redirect-uri}")
    private String redirectUri;

    @Value("${spring.security.oauth2.client.registration.keycloak.authorization-grant-type}")
    private String authorizationGrantType;

    @Value("${spring.security.oauth2.client.registration.keycloak.client-authentication-method}")
    private String clientAuthenticationMethod;

    @Value("${spring.security.oauth2.client.registration.keycloak.scope}")
    private String scope;

    @Value("${spring.security.oauth2.provider.keycloak.issuer-uri}")
    private String issuerUri;

    @Value("${spring.security.oauth2.provider.keycloak.user-name-attribute}")
    private String userNameAttribute;

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String jwtIssuerUri;

    @Deprecated
    public KeycloakConfig() {
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getAuthorizationGrantType() {
        return authorizationGrantType;
    }

    public String getClientAuthenticationMethod() {
        return clientAuthenticationMethod;
    }

    public String getScope() {
        return scope;
    }

    public String getIssuerUri() {
        return issuerUri;
    }

    public String getUserNameAttribute() {
        return userNameAttribute;
    }

    public String getJwtIssuerUri() {
        return jwtIssuerUri;
    }
}