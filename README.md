# Проект по автоматизации тестирования платформы для трейдеров и инвесторов Tradingview
> <a target="_blank" href="https://ru.tradingview.com/">Ссылка на портал</a>

![This is an image](images/screenshots/tv.png)

## :page_with_curl: Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Запуск тестов](#rocket-запуск-тестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска теста в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

## :wrench: Использованный стек технологий

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/Allure_TestOps.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

Автотесты написаны на <code>Java</code> с использованием <code>JUnit 5</code> и <code>Gradle</code>.
Для UI-тестов использован фреймворк [Selenide](https://selenide.org/).
Запуск тестов можно осуществлять локально или с помощью [Selenoid](https://aerokube.com/selenoid/).
Также реализована сборка в <code>Jenkins</code> с формированием Allure-отчета и отправкой уведомления с результатами в <code>Telegram</code> после завершения прогона.
Тестовая модель хранится в Allure TestOps и формируется автоматически на основе выгрузки результатов автотестов.

Allure-отчет включает в себя:
* шаги выполнения тестов;
* скриншот страницы в браузере в момент окончания автотеста;
* Page Source;
* логи браузерной консоли;
* видео выполнения автотеста.

## :boom: Запуск тестов

### Локальный запуск тестов
С параметрами по умолчанию
```
gradle clean test
```

При необходимости можно изменить дефолтные параметры запуска
```
clean
test
-Dusername=${USER_NAME}
-Dpassword=${PASSWORD}
-Dbrowser_name=${BROWSER_NAME}
-Dbrowser_version=${BROWSER_VERSION}
-Dbrowser_size=${BROWSER_SIZE}
```

### Запуск тестов на удаленном браузере

```
clean
test
-Dusername=${USER_NAME}
-Dpassword=${PASSWORD}
-Dbrowser_name=${BROWSER_NAME}
-Dbrowser_version=${BROWSER_VERSION}
-Dbrowser_size=${BROWSER_SIZE}
-Dremote_url=${REMOTE_BROWSER_URL}
```

### Параметры сборки

* <code>USER_NAME</code> – имя пользователя. По-умолчанию - <code>Divog74804</code>
* <code>PASSWORD</code> – пароль. По-умолчанию - <code>divog74804</code>
* <code>BROWSER_NAME</code> – браузер, в котором будут выполняться тесты. По-умолчанию - <code>chrome</code>
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По-умолчанию - <code>100.0</code>
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По-умолчанию - <code>1920x1080</code>
* <code>REMOTE_BROWSER_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> Сборка в Jenkins

> <a target="_blank" href="https://jenkins.autotests.cloud/job/qa_guru_final_project_ui_Sviridov/">Ссылка на сборку в Jenkins</a>

<p align="center">
<img title="Jenkins Build" src="images/screenshots/jenkinsBuild.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure_Report.svg"> Пример Allure-отчета
### Overview

<p align="center">
<img title="Allure Overview" src="images/screenshots/allureReportMain.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="images/screenshots/allureReportTests.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="images/logo/Allure_TestOps.svg"> Интеграция с Allure TestOps

> <a target="_blank" href="https://allure.autotests.cloud/project/1699/dashboards">Ссылка на проект</a>

Полная статистика о прохождении тестов, отчеты и результаты прогонов хранятся в Allure TestOps. Тестовая модель формируется автоматически на основе выгрузки результатов автотестов

### Примеры дашбордов

<p align="center">
<img title="Dashboards" src="images/screenshots/dashboards.png">
</p>

### Список тест-кейсов

<p align="center">
<img title="Dashboards" src="images/screenshots/testCases.png">
</p>

### Описание тестового сценария

<p align="center">
<img title="Dashboards" src="images/screenshots/testCase.png">
</p>

### Список тестовых прогонов

<p align="center">
<img title="Dashboards" src="images/screenshots/launches.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне

<p align="center">
<img width="70%" title="Telegram Notifications" src="images/screenshots/notificationExample.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Selenoid" src="images/logo/Selenoid.svg"> Видео примера запуска теста в Selenoid

К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже
<p align="center">
  <img title="Selenoid Video" src="images/gif/videoExample.gif">
</p>
