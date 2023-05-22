package com.craftzn.authserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties(prefix = "keycloak.oauth2.client.registration")
public class KeycloakClientRegistration {
    private String clientId;
    private String clientName;
    private String redirectUri;
    private String authorizationGrantType;
    private String clientAuthenticationMethod;
    private String scope;

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
}