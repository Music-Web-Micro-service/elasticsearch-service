FROM openjdk:17
WORKDIR /app

COPY ./target/elasticsearch-service-0.0.1-SNAPSHOT.jar ./target/elasticsearch-service-0.0.1-SNAPSHOT.jar

EXPOSE 8090

# Command to run your Spring Boot application
CMD ["java", "-jar", "./target/elasticsearch-service-0.0.1-SNAPSHOT.jar"]