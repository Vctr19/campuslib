FROM maven:3.9-sapmachine-17 AS build
RUN mvn clean install

FROM amazoncorretto:17.0.6-al2023 AS deploy
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]