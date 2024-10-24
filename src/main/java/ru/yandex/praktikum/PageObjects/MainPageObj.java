package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageObj {

    private WebDriver driver;

    //Кнопка Личный Кабинет
    private By buttonPersonalAccount = By.xpath(".//*[text() = 'Личный Кабинет']");


    public MainPageObj(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по кнопке Личный Кабинет
    public void clickBtnPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }
}
