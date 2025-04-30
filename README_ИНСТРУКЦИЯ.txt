README_ИНСТРУКЦИЯ

Ссылка на этот прект в Replit:
https://replit.com/@sozinvladislav/TelegramMailer
user name: @sozinvladislav

Chat ID своего бота как узнать?:
Напишите боту @userinfobot или @myidbot
Отправьте команду /start или /getid
Chat ID моего бота:
@tess_SV
Id: 5799431854    - это Chat ID этого бота (только цифры)

ИНСТРУКЦИЯ ПО ИСПОЛЬЗОВАНИЮ ТЕЛЕГРАМ БОТА ДЛЯ EMAIL РАССЫЛКИ:

- зайти на Replit.com, а именно сюда: https://replit.com/@sozinvladislav/TelegramMailer#src/main/java/org/example/Main.java
почта (она же логин): sozin.vladislav@gmail.com
пароль: sozsoz1967.Aaaa

- В главном окне (большое окно по центру, чуть справа (левее будет вертикальное меню)), убедиться что открыта вкладка: Console
, если её нет - откройте её, нажав над окном: плюсик (+), и выбрав в списке: Console

- Нажать вверху по центру кнопку: Run (т.е.: Запуск), если на её месте будет кнопка: Stop, - нажать на неё, на её месте появится
кнопка: Run.
- Дождаться, когда в окне: Console, после другой загруженной информации, появится надпись: Бот запущен.
- Перейти в приложение Telegram (при этом Replit.com - не выключать, пусть он работает)
- Найти там такой Telegram бот: @BES_Mailing_bot  (или ссылка: https://t.me/BES_Mailing_bot)
- В телеграм боте отправить боту команду: /start
- Далее следовать инструкциям,
    а именно: бот попросит в столбик написать email адреса (за одну отправку не более 100адресов), и нажать кнопку: Отправить.
    далее бот попросит ввести текстовое сообщение, - ввести его и нажать кнопку: Отправить.
    далее дождаться сообщения от бота: Сообщения успешно отправлены.



Инструкция, как пользоваться кодом в файле README_ИНСТРУКЦИЯ в корневой папке проекта
Название бота для этого проекта (переименованное, просто для меня в списке ботов):
Mailing_bot
Название этого бота правильное:
@BES_Mailing_bot
Ссылка на этот бот:
https://t.me/BES_Mailing_bot
Токен этого бота:
7658983765:AAFaNCkR8D5O74u-YkMVZyjxuePRXY1NZ64
Java проект по контексту поиска этот: Email_Rassylka_cherez_Telegram_bot

Команды в терминале bash для проверки работы проекта:
1. Для Telegram-бота:
bash
mvn compile exec:java -Dexec.mainClass="org.example.Main"
2. Для теста email без бота:
bash
mvn compile exec:java -Dexec.mainClass="org.example.SendEmail"
3. Ещё проверка:
mvn clean compile exec:java

Здесь инфо, как создать рассылку: https://dev.to/suprsend/how-to-send-email-notifications-using-java-3-methods-with-code-examples-2ckd
Как создать пароль для внешнего сервиса , для внешнего приложения:
• Перейдите на страницу безопасности вашей учетной записи Mail.ru.
• Найдите раздел, связанный с "Паролями приложений" или "Доступом приложений".
• Создайте новый пароль приложения. Вам будет предоставлен уникальный код.
Создаётся здесь: https://id.mail.ru/security
В итоге создался здесь: https://account.mail.ru/user/2-step-auth/passwords?back_url=https%3A%2F%2Fid.mail.ru%2Fsecurity
