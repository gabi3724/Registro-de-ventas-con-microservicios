FROM openjdk:21-jdk-oracle
ARG JAR_FILE=target/productos-service-0.0.1.jar
COPY ${JAR_FILE} productos_service.jar
CMD ["java", "-jar", "productos_service.jar", "--server.port=8001"]
CMD ["java", "-jar", "productos_service.jar", "--server.port=8002"]
#ENTRYPOINT ["java", "-jar", "productos_service.jar"]