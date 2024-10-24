package ru.yandex.praktikum.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageObj {

    private WebDriver driver;

    //Кнопка Личный Кабинет
    private By buttonPersonalAccount = By.xpath(".//*[text() = 'Личный Кабинет']");
    //Кнопка Войти в аккаунт
    private By buttonEnterAccount = By.xpath(".//*[text() = 'Войти в аккаунт']");
    //Заголовок Соберите бургер
    private By headerCreateBurger = By.xpath(".//*[text() = 'Соберите бургер']");
    //Раздел Булки
    private By sectionBuns = By.xpath(".//div/span[text() = 'Булки']");
    //Раздел Соусы
    private By sectionSauces = By.xpath(".//div/span[text() = 'Соусы']");
    //Раздел Начинки
    private By sectionFillings = By.xpath(".//div/span[text() = 'Начинки']");
    //Заголовок Булки
    private By headerBuns = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Булки']");
    //Заголовок Соусы
    private By headerSauces = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Соусы']");
    //Заголовок Начинки
    private By headerFillings = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Начинки']");

    private By elTest = By.className("Modal_modal_overlay__x2ZCr");


    public MainPageObj(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по кнопке Личный Кабинет
    public void clickBtnPersonalAccount() {
        //new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(driver.findElement(this.buttonPersonalAccount)));
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(driver.findElement(this.buttonPersonalAccount)));
        //new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOf(driver.findElement(this.elTest)));
        //new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(driver.findElement(this.elTest))));

        driver.findElement(this.buttonPersonalAccount).click();
    }

    //Клик по кнопке Войти в аккаунт
    public void clickBtnEnterAccount() {
        driver.findElement(this.buttonEnterAccount).click();
    }

    //Клик по разделу Булки
    public void clickSectionBuns() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(driver.findElement(this.sectionBuns)));

        driver.findElement(this.sectionBuns).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(this.headerBuns)));
    }

    //Клик по разделу Соусы
    public void clickSectionSauces() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(driver.findElement(this.sectionSauces)));

        driver.findElement(this.sectionSauces).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(this.headerSauces)));
    }

    //Клик по разделу Начинки
    public void clickSectionFillings() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(driver.findElement(this.sectionFillings)));

        driver.findElement(this.sectionFillings).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(this.headerFillings)));
    }

    //Отображение заголовка Булки
    public boolean isHeaderBuns() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(driver.findElement(this.sectionBuns)));

        return driver.findElement(this.headerBuns).isDisplayed();
    }

    //Отображение заголовка Соусы
    public boolean isHeaderSauces() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(driver.findElement(this.sectionSauces)));

        return driver.findElement(this.headerSauces).isDisplayed();
    }

    //Отображение заголовка Начинки
    public boolean isHeaderFillings() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(driver.findElement(this.sectionFillings)));

        return driver.findElement(this.headerFillings).isDisplayed();
    }

    //Наличие заголовка Соберите бургер
    public boolean isHeaderCreateBurger() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(this.headerCreateBurger)));

        return driver.findElement(this.headerCreateBurger).isDisplayed();
    }
}
