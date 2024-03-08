FROM openjdk:17
EXPOSE 8703
#WORKDIR /app
COPY . .
ADD target/movie-api-service.jar  app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]