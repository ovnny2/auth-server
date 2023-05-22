package com.craftzn.authserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties(prefix = "keycloak.oauth2.client.provider")
public class KeycloakClientProvider {
    private String issuerUri;
    private String userNameAttribute;

    public String getIssuerUri() {
        return issuerUri;
    }

    public String getUserNameAttribute() {
        return userNameAttribute;
    }
}