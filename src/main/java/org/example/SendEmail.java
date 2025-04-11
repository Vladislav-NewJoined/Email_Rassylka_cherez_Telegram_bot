package org.example;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    public static void main(String[] args) {

//    Инструкция, как пользоваться кодом в файле README_ИНСТРУКЦИЯ в корневой папке проекта
//    Здесь инфо, как создать рассылку: https://dev.to/suprsend/how-to-send-email-notifications-using-java-3-methods-with-code-examples-2ckd
//    Как создать пароль для внешнего сервиса , для внешнего приложения:
//   • Перейдите на страницу безопасности вашей учетной записи Mail.ru.
//   • Найдите раздел, связанный с "Паролями приложений" или "Доступом приложений".
//   • Создайте новый пароль приложения. Вам будет предоставлен уникальный код.
//    Создаётся здесь: https://id.mail.ru/security
//    В итоге создался здесь: https://account.mail.ru/user/2-step-auth/passwords?back_url=https%3A%2F%2Fid.mail.ru%2Fsecurity


                // Настройки SMTP-сервера Mail.ru
        String host = "smtp.mail.ru";
        String port = "465"; // Порт для SSL
        String username = "sozin.vladislav@mail.ru"; // Ваш email
        String password = "XE2u0sb8qFyJttebpXuK"; // Ваш пароль
//        String password = "sozsoz1967.A"; // Ваш пароль

        // Настройка свойств
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // Включаем аутентификацию
        props.put("mail.smtp.ssl.enable", "true"); // Включаем SSL для порта 465
        props.put("mail.smtp.host", host); // Указываем SMTP-сервер
        props.put("mail.smtp.port", port); // Указываем порт для SSL

        // Создание сессии
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        // Включаем режим отладки
        session.setDebug(true);

        try {
            // Создание сообщения
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sozin.vladislav@mail.ru"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("sozin.vladislav@mail.ru"));
            message.setSubject("Чиглинцев Владимир. Тема письма.");
            message.setText("Чиглинцев Владимир. Текст письма");

            // Отправка сообщения
            Transport.send(message);

            System.out.println("Письмо успешно отправлено.");

        } catch (MessagingException e) {
            e.printStackTrace(); // Выводим полный стек ошибки
            throw new RuntimeException(e);
        }
    }
}