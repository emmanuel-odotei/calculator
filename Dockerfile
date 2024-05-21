FROM openjdk:17-alpine

WORKDIR /app

EXPOSE 8081

RUN mvn clean install

COPY target/calculator-1.0.0.jar /app/calculator-1.0.0.jar

CMD ["java", "-jar", "  calculator-1.0.0.jar"]