package ru.yandex.praktikum.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPageObj {

    private WebDriver driver;

    //Кнопка Войти
    private By buttonLogin = By.xpath(".//a[text() = 'Войти']");

    public ForgotPasswordPageObj(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по кнопке Войти
    public void clickBtnLogin() {
        driver.findElement(this.buttonLogin).click();
    }
}
