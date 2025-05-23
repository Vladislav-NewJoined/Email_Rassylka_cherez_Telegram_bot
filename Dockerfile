# Этап сборки
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

# Этап запуска
FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=build /app/target/app.jar ./app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
