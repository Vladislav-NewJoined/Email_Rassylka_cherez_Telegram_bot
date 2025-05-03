# Этап сборки
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Копируем только pom.xml сначала для кэширования зависимостей
COPY pom.xml .
# Загружаем все зависимости
RUN mvn dependency:go-offline -B

# Теперь копируем исходный код
COPY src ./src

# Собираем проект
RUN mvn clean package -DskipTests

# Этап запуска
FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=build /app/target/Email_Rassylka_cherez_Telegram_bot.jar ./app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
