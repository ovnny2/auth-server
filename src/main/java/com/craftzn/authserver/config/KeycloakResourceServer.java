package com.craftzn.authserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties(prefix = "keycloak.oauth2.resourceserver")
public class KeycloakResourceServer {
    private String jwtIssuerUri;

    public String getJwtIssuerUri() {
        return jwtIssuerUri;
    }
}