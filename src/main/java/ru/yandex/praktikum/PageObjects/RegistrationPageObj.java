package ru.yandex.praktikum.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageObj {
    private WebDriver driver;

    //Кнопка Зарегистрироваться
    private By buttonRegistration = By.xpath(".//*[text() = 'Зарегистрироваться']");
    //Поле Имя
    private By name = By.xpath(".//*[text()='Имя']/..//input");
    //Поле Email
    private By email = By.xpath(".//*[text()='Email']/..//input");
    //Поле Пароль
    private By password = By.xpath(".//*[text()='Пароль']/..//input");
    //Надпись Некорректный пароль
    private By incorrectPasswordText = By.xpath(".//*[text()='Некорректный пароль']");
    //Кнопка Войти
    private By buttonEnter = By.xpath(".//*[text()='Войти']");


    public RegistrationPageObj(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнить Имя
    public void setName(String name) {
        driver.findElement(this.name).sendKeys("");
        driver.findElement(this.name).sendKeys(name);
    }

    //Заполнить Email
    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys("");
        driver.findElement(this.email).sendKeys(email);
    }

    //Заполнить Пароль
    public void setPassword(String password) {
        driver.findElement(this.password).sendKeys("");
        driver.findElement(this.password).sendKeys(password);
    }

    //Клик по кнопке Зарегистрироваться
    public void clickBtnRegistration() {
        driver.findElement(this.buttonRegistration).click();
    }

    //Клик по кнопке Войти
    public void clickBtnEnter() {
        driver.findElement(this.buttonEnter).click();
    }

    //Наличие текста Некорректный пароль
    public boolean isWrongPassword() {
        return driver.findElement(this.incorrectPasswordText).isDisplayed();
    }
}
