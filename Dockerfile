FROM amazoncorretto:17.0.6-al2023
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]