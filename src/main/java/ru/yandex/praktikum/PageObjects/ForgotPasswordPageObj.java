package ru.yandex.praktikum.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageObj {

    private WebDriver driver;

    //Кнопка Зарегистрироваться
    private By buttonRegistration = By.xpath(".//*[text() = 'Зарегистрироваться']");
    //Поле Email
    private By email = By.name("name");
    //Поле Пароль
    private By password = By.name("Пароль");
    //Кнопка Войти
    private By buttonLogin = By.xpath(".//button[text() = 'Войти']");
    //Заголовок Вход
    private By headerLogin = By.xpath(".//*[text() = 'Вход']");

    public LoginPageObj(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по кнопке Зарегистрироваться
    public void clickBtnRegistration() {
        driver.findElement(this.buttonRegistration).click();
    }

    //Заполнить Email
    public void setEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(this.headerLogin)));

        driver.findElement(this.email).sendKeys("");
        driver.findElement(this.email).sendKeys(email);

    }

    //Заполнить Пароль
    public void setPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(this.headerLogin)));

        driver.findElement(this.password).sendKeys("");
        driver.findElement(this.password).sendKeys(password);

    }

    //Наличие заголовка Вход
    public boolean isHeaderLogin() {
        return driver.findElement(this.headerLogin).isDisplayed();
    }

    //Клик по кнопке Зарегистрироваться
    public void clickBtnLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(driver.findElement(this.buttonLogin)));

        driver.findElement(this.buttonLogin).click();
    }
}
