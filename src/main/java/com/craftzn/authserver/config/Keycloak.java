package com.craftzn.authserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "keycloak")
public class Keycloak {

    private String realm;
    private String resource;
    private String hostnameUrl;
    private String publicClient;
    private String sslRequired;
    private String hostnameStrictHttps;
    private String hostnameStrictBackchannel;
    private String healthEnable;
    private String statisticsEnable;
    private String spiConnectionsHttpClientDefaultDisableTrustManager;

    @Deprecated
    public Keycloak() { }

    public String getRealm() { return realm; }

    public String getResource() { return resource; }

    public String getHostnameUrl() { return hostnameUrl; }

    public String getPublicClient() { return publicClient; }

    public String getSslRequired() { return sslRequired; }

    public String getHostnameStrictHttps() { return hostnameStrictHttps; }

    public String getHostnameStrictBackchannel() { return hostnameStrictBackchannel; }

    public String getHealthEnable() { return healthEnable; }

    public String getStatisticsEnable() { return statisticsEnable; }

    public String getSpiConnectionsHttpClientDefaultDisableTrustManager() {
        return spiConnectionsHttpClientDefaultDisableTrustManager;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setHostnameUrl(String hostnameUrl) {
        this.hostnameUrl = hostnameUrl;
    }

    public void setPublicClient(String publicClient) {
        this.publicClient = publicClient;
    }

    public void setSslRequired(String sslRequired) {
        this.sslRequired = sslRequired;
    }

    public void setHostnameStrictHttps(String hostnameStrictHttps) {
        this.hostnameStrictHttps = hostnameStrictHttps;
    }

    public void setHostnameStrictBackchannel(String hostnameStrictBackchannel) {
        this.hostnameStrictBackchannel = hostnameStrictBackchannel;
    }

    public void setHealthEnable(String healthEnable) {
        this.healthEnable = healthEnable;
    }

    public void setStatisticsEnable(String statisticsEnable) {
        this.statisticsEnable = statisticsEnable;
    }

    public void setSpiConnectionsHttpClientDefaultDisableTrustManager(String spiConnectionsHttpClientDefaultDisableTrustManager) {
        this.spiConnectionsHttpClientDefaultDisableTrustManager = spiConnectionsHttpClientDefaultDisableTrustManager;
    }
}