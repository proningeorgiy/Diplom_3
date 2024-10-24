package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class InitBrowser {

    private WebDriver driver;

    //Выбор браузера и открытие сайта
    public InitBrowser() {
        /*
        if ("firefox".equals(System.getProperty("browser")))
            startFireFox();
        else
            startChrome();
        */
        if ("yandex".equals(System.getProperty("browser")))
            startYandex();
        else
            startChrome();

        openBrowser("https://stellarburgers.nomoreparties.site/");

        //closeCookiesMassage();
    }

    //Запуск Chrome
    public void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //Запуск FireFox. Дополнительные сведения см. в README.md
    /*
    public void startFireFox() {
        WebDriverManager.firefoxdriver().setup();
        var opts = new FirefoxOptions().configureFromEnv();
        driver = new FirefoxDriver(opts);
    }
     */

    //Запуск Yandex. Дополнительные сведения см. в README.md
    public void startYandex() {
        //WebDriverManager.firefoxdriver().setup();
        //var opts = new FirefoxOptions().configureFromEnv();
        //driver = new FirefoxDriver(opts);
    }

    //Открытие браузере
    public void openBrowser(String url) {
        driver.get(url);
    }

    //Закрытие сообщения о куки
/*
    public void closeCookiesMassage() {
        By cookiesMessage = By.className("App_CookieButton__3cvqF");
        driver.findElement(cookiesMessage).click();
    }

 */

    public WebDriver getDriver() {
        return driver;
    }

    //Закрытие браузера
    public void closeBrowser() {
        this.driver.quit();
    }
}
