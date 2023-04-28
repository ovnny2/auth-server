FROM openjdk:17-alpine
WORKDIR /
ARG JAR_FILE=/build/libs/*.jar

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar","--debug"]

EXPOSE 8081