package ru.yandex.praktikum.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccauntPageObj {

    private WebDriver driver;

    //Кнопка Профиль
    private By buttonProfile = By.xpath(".//a[text() = 'Профиль']");
    //Кнопка Конструктор
    private By buttonConstructor = By.xpath(".//p[text()='Конструктор']");
    //Логотип
    private By logotip = By.className("AppHeader_header__logo__2D0X2");
    //Кнопка Выход
    private By buttonExit = By.xpath(".//button[text() = 'Выход']");

    public PersonalAccauntPageObj(WebDriver driver) {
        this.driver = driver;
    }

    //Наличие кнопки Профиль
    public boolean isButtonProfile() {
        return driver.findElement(this.buttonProfile).isDisplayed();
    }

    //Клик по кнопке Конструктор
    public void clickBtnConstructor() {
        driver.findElement(this.buttonConstructor).click();
    }

    //Клик по логотипу
    public void clickLogotip() {
        driver.findElement(this.logotip).click();
    }

    //Клик по кнопке Выход
    public void clickBtnExit() {
        driver.findElement(this.buttonExit).click();
    }
}

