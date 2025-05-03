package org.example;

import com.sun.net.httpserver.HttpServer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {
        try {
            // Запуск Telegram бота
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            // Создаем экземпляр вашего существующего бота MailingBot
            MailingBot bot = new MailingBot();

            // Регистрируем бота
            botsApi.registerBot(bot);
            System.out.println("Бот запущен!");

            // Создание простого HTTP-сервера для Render
            startHttpServer();

        } catch (TelegramApiException e) {
            System.err.println("Ошибка при запуске бота: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void startHttpServer() throws IOException {
        // Получаем порт из переменной окружения или используем 8080 по умолчанию
        String port = System.getenv("PORT");
        if (port == null || port.isEmpty()) {
            port = "8080";
        }

        // Создаем HTTP-сервер на указанном порту
        HttpServer server = HttpServer.create(new InetSocketAddress(Integer.parseInt(port)), 0);

        // Добавляем простой обработчик для проверки работоспособности
        server.createContext("/health", exchange -> {
            String response = "BES_Mailing_bot is running!";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.getResponseBody().close();
        });

        // Запускаем сервер
        server.start();
        System.out.println("HTTP сервер запущен на порту " + port);
    }
}
