FROM openjdk:21-jdk-oracle
ARG JAR_FILE=target/carrito-service-0.0.1.jar
COPY ${JAR_FILE} carritos_service.jar
ENTRYPOINT ["java", "-jar", "carritos_service.jar"]