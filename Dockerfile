# Этап сборки
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Копируем только pom.xml сначала для кэширования зависимостей
COPY pom.xml .
# Загружаем все зависимости
RUN mvn dependency:go-offline -B

# Теперь копируем исходный код
COPY src ./src

# Собираем проект с явным указанием версии Java
RUN mvn clean package -DskipTests -Dmaven.compiler.source=17 -Dmaven.compiler.target=17

# Этап запуска
FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=build /app/target/*.jar ./app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

