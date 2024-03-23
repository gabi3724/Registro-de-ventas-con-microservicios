FROM openjdk:21-jdk-oracle
ARG JAR_FILE=target/ventas-service-0.0.1.jar
COPY ${JAR_FILE} ventas_service.jar
ENTRYPOINT ["java", "-jar", "ventas_service.jar"]