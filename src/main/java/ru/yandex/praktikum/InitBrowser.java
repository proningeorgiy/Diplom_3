package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

import static io.restassured.RestAssured.given;

public class InitBrowser {

    final String USERDATA = "/api/auth/user";

    private WebDriver driver;

    private String accessToken;

    //Выбор браузера и открытие сайта
    public InitBrowser() {
        accessToken = "";
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";

        if ("yandex".equals(System.getProperty("browser")))
            startYandex();
        else
            startChrome();

        openBrowser("https://stellarburgers.nomoreparties.site/");
    }

    //Запуск Chrome
    public void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //Запуск Yandex. Дополнительные сведения см. в README.md
    public void startYandex() {

        var opts = new ChromeOptions();
        opts.setBinary(System.getProperty("webdriver.yandex.bin"));
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(opts);

    }

    //Открытие браузере
    public void openBrowser(String url) {
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }

    //Удаление пользователя
    public void deleteUser() {
        if (!accessToken.isEmpty())
            given()
                    .header("Authorization", accessToken)
                    .contentType(ContentType.JSON)
                    .delete(USERDATA);
    }

    //Получение
    public void getAccessTokenFromLocalStorage() {
        WebStorage webStorage = (WebStorage) new Augmenter().augment(this.driver);
        LocalStorage localStorage = webStorage.getLocalStorage();

        this.accessToken = localStorage.getItem("accessToken");
        if (this.accessToken == null) this.accessToken = "";
    }

    //Закрытие браузера
    public void closeBrowser() {

        deleteUser();

        this.driver.quit();
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
