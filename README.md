![En desarollo](https://img.shields.io/badge/Estado-EN%20DESAROLLO-green)
![Java](https://img.shields.io/badge/Java-17-blue?style=flat)
![Maven](https://img.shields.io/badge/MVN-4.0.0-blue)
![Static Badge](https://img.shields.io/badge/Spring-3.2.2-blue?style=flat&logo=spring)
![Static Badge](https://img.shields.io/badge/Docker-4.27.2-blue?style=flat&logo=docker)

# Registro de ventas con micorservicios
El proyecto se centra en el desarrollo de un backend con arquitectura de microservicios donde se puedan registrar las ventas de un comercio. Los microservicios en cuestion son las ventas, los carritos y los productos. 

# Surgimiento
Se trata del proyecto final de un curso que realice sobre microservicios con Spring Cloud. El objetivo es poder utilizarlo como portafolio. El [enunciado](https://github.com/gabi3724/Registro-de-ventas-con-microservicios/blob/main/Enunciado%20del%20proyecto.pdf) del proyecto se encuentra en este mismo repositorio. 

# Tecnologías y características
Algunas de las tecnologías y patrones aplicados a lo largo del proyecto fueron las siguientes:
- Java 21 + Spring Boot + Spring Cloud + Maven
- Uso de FEIGN y RestTemplate para comsumir otras APIs
- Service Registry y Service Discovery con Eureka Server
- Balanceo de carga (Load Balancing)
- Circuit Breaker mediante Resilience4J
- API Gateway para acceder a los microservicios desde un solo puerto
- Configuracion centralizada mediante config server y github
- Uso de Docker para desplegar todo el ecosistema de microservicios

