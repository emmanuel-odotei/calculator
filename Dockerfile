FROM openjdk:17-alpine

WORKDIR /app

EXPOSE 8081

COPY target/calculator-1.0.0.jar /app/calculator-1.0.0.jar

CMD ["java", "-jar", "  calculator-1.0.0.jar"]