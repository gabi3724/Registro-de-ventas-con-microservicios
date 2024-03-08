FROM openjdk:21-jdk-oracle
ARG JAR_FILE=target/config-server-0.0.1.jar
COPY ${JAR_FILE} config_server.jar
ENTRYPOINT ["java", "-jar", "config_server.jar"]