# Яндекс Практикум. Диплом по автоматизатии, третья часть

## В проекте используются: Java 11, Maven 3.9.6, JUnit 4.13.2, AspectJ 1.9.7, Allure 2.10.0, REST Assured 5.5.0, GSON 2.8.9, Lombok 1.18.20, Selenium 4.23.0, WebDriverManager 5.9.2

### запуск тестирования

```bash
mvn clean test
```

### запуск для Yandex

Имеющийся chromedriver не работал с Яндекс браузером: ругался, что у браузера версия 126, а он работает только со 129.
Поэтому я скачал отдельную версию chromedriver для 126.
Этот chromedriver положил в ресурсы
И обязательно нужно указать верный путь к исполнительному файлу Яндекс браузера

```bash
mvn clean test -Dbrowser=yandex '-Dwebdriver.yandex.bin=C:\Users\ImmortalGogi\AppData\Local\Yandex\YandexBrowser\Application\browser.exe' 
```