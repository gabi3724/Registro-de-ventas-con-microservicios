FROM openjdk:21-jdk-oracle
ARG JAR_FILE=target/productos-service-0.0.1.jar
COPY ${JAR_FILE} productos_service.jar
ENTRYPOINT ["java", "-jar", "productos_service.jar"]