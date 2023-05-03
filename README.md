# auth-server
Dedicated to provide authentication services using Keycloak as Identification and Access Provider (IAM) using OpenId Connect and Oauth2

- **Docker host Subnet** = 172.21.0.0/16
- **Gateway** = 172.21.0.1
- **keycloack-sso IP** = 172.21.0.2
- **auth-server IP** = 172.21.0.3

___

![img_1.png](src/main/resources/static/docker-network.png)

## Authentication Flow

- ### GET RESOURCES - {{resource-host}}/v1/users 200 
  - ![img.png](src/main/resources/static/get__v1_users.png)
- ### REDIRECT CLIENT 302 {{resource-host}}/oauth2/authorization/keycloak
  - ![img.png](src/main/resources/static/img.png)
- ### GET FORM UI 200 {{issuer-host}}/realms/craftzn/protocol/openid-connect/auth 
  - ![img_1.png](src/main/resources/static/img_1.png)
- ### POST /realms/craftzn/login-actions/authenticate
  - ![img_2.png](src/main/resources/static/img_2.png)
- ### REDIRECT 300 FOUND {{resource-host}}/login/oauth2/code/keycloak
  - ![img_3.png](src/main/resources/static/img_3.png)
- ### GET RESOURCES 200 {{resource-host}}/v1/users
  - ![img_4.png](src/main/resources/static/img_4.png)
- ### RESPONSE 200 OK
  - ![img_5.png](src/main/resources/static/img_5.png)