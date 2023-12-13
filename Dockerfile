FROM eclipse-temurin:8
WORKDIR /app
COPY ./target/stampmarket-user-1.0-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]