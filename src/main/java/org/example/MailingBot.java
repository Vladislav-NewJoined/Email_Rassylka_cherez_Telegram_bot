package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MailingBot extends TelegramLongPollingBot {
    private List<String> emailList = new ArrayList<>();
    private boolean waitingForEmails = false;
    private boolean waitingForMessage = false;
    private String messageText = "";

    @Override
    public String getBotUsername() {
        return "BES_Mailing_bot";
    }

    @Override
    public String getBotToken() {
        return "7658983765:AAFaNCkR8D5O74u-YkMVZyjxuePRXY1NZ64";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }

        long chatId = update.getMessage().getChatId();
        String userInput = update.getMessage().getText();

        if ("/start".equals(userInput)) {
            waitingForEmails = true;
            waitingForMessage = false;
            sendMessage(chatId, "Введите в столбик список адресов email:");
        } else if (waitingForEmails) {
            String[] emails = userInput.split("\n");
            for (String email : emails) {
                emailList.add(email.trim());
            }
            waitingForEmails = false;
            waitingForMessage = true;
            sendMessage(chatId, "Теперь введите текст сообщения:");
        } else if (waitingForMessage) {
            messageText = userInput;
            sendEmails(emailList, messageText);
            sendMessage(chatId, "Рассылка выполнена!");
            emailList.clear();
            waitingForMessage = false;
        }
    }

    private void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendEmails(List<String> emails, String text) {
        String host = "smtp.mail.ru";
        String port = "465";
        String username = "sozin.vladislav@mail.ru";
        String password = "XE2u0sb8qFyJttebpXuK";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            for (String email : emails) {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(email)
                );
                message.setSubject("Сообщение от BES Mailing Bot.");
                message.setText(text);
                Transport.send(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
