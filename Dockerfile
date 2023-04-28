FROM openjdk:17-alpine
WORKDIR /
ARG JAR_FILE=/build/libs/*.jar

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar", "-b", "0.0.0.0"]

EXPOSE 8081