package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageObj {
    private WebDriver driver;

    //Кнопка Зарегистрироваться
    private By buttonRegistration = By.xpath(".//*[text() = 'Зарегистрироваться']");
    //Поле Имя
    private By name = By.xpath(".//*[text() = 'Имя']");
    //Поле Email
    private By email = By.xpath(".//*[text() = 'Email']");
    //Поле Пароль
    private By password = By.xpath(".//*[text() = 'Пароль']");


    public RegistrationPageObj(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнить Имя
    public void setName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    //Заполнить Email
    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    //Заполнить Пароль
    public void setPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    //Клик по кнопке Зарегистрироваться
    public void clickBtnRegistration() {
        driver.findElement(buttonRegistration).click();
    }
}
