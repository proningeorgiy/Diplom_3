package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObj {

    private WebDriver driver;

    //Кнопка Зарегистрироваться
    private By buttonRegistration = By.xpath(".//*[text() = 'Зарегистрироваться']");

    public LoginPageObj(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по кнопке Зарегистрироваться
    public void clickBtnRegistration() {
        driver.findElement(buttonRegistration).click();
    }
}
