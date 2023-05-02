FROM openjdk:8-jdk-alpine
COPY target/spring_with_kafka-1.0.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]