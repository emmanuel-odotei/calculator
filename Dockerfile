FROM openjdk:17-alpine

WORKDIR /app

EXPOSE 8081

COPY . /app

RUN .mvn clean package

CMD ["java", "-jar", "app/target/calculator-1.0.0.jar"]