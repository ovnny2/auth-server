package com.craftzn.authserver.config.keycloak;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "spring.security.oauth2.client.provider.keycloak")
public class KeycloakClientProvider {

    private String issuerUri;
    private String userNameAttribute;

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