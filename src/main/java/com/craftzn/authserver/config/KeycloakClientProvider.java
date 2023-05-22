package com.craftzn.authserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.security.oauth2.client.provider.keycloak")
public class KeycloakClientProvider {

    private String issuerUri;
    private String userNameAttribute;

    @Deprecated
    public KeycloakClientProvider() { }

    public String getIssuerUri() {
        return issuerUri;
    }

    public String getUserNameAttribute() {
        return userNameAttribute;
    }

    public void setIssuerUri(String issuerUri) {
        this.issuerUri = issuerUri;
    }

    public void setUserNameAttribute(String userNameAttribute) {
        this.userNameAttribute = userNameAttribute;
    }
}