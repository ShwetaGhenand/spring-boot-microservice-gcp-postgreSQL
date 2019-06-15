# Spring Boot Microservice and GCP PostgreSQL Database

A Spring-Boot application which will interact with GCP PostgreSQL doing CRUD operations. I will be using Spring data JPA with hibernate for the same.

Install [java](https://oracle.com) and [Maven](https://maven.apache.org).example-identity-service:latestexample-identity-serviceexample-identity-service

###### Run ErrorCount locally
```
1. mvn clean
2. mvn install
3. mvn spring-boot:run
```

###### Run ErrorCount with Docker

```
1.mvn clean
2.mvn clean install
3.mvn clean install dockerfile:build
4.winpty docker run -p 8081:8080 -it example-identity-service(Windows)
 docker run -p 8081:8080 -it example-identity-service(Linux)


```


###### Test Application
The application will be running on http://localhost:8081/swagger-ui.html#!/

