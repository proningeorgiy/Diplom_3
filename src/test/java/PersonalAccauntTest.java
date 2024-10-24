import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.praktikum.InitBrowser;
import ru.yandex.praktikum.PageObjects.ForgotPasswordPageObj;
import ru.yandex.praktikum.PageObjects.LoginPageObj;
import ru.yandex.praktikum.PageObjects.MainPageObj;
import ru.yandex.praktikum.PageObjects.RegistrationPageObj;

import java.util.concurrent.TimeUnit;

public class LoginUserTest {

    InitBrowser initBrowser;

    String accessToken = "";

    public LoginUserTest() {
        initBrowser = new InitBrowser();

        initBrowser.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт")
    @Description("Переход на страницу авторизации по клику на кнопку Войти в аккаунт на главной странице")
    public void loginUserByEnterAccauntButtonTest() {

        //Клик по кнопке Войти в аккаунт
        btnEnterAccauntClick();

        //Проверка перехода на страницу Авторизации
        checkLoginUser();
    }

    @Test
    @DisplayName("Вход по кнопке Личный кабинет")
    @Description("Переход на страницу авторизации по клику на кнопку Личный кабинет на главной странице")
    public void loginUserByPersonalAccauntButtonTest() {

        //Клик по кнопке Личный Кабинет
        btnPersonalAccountClick();

        //Проверка перехода на страницу Авторизации
        checkLoginUser();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Переход на страницу авторизации по клику на кнопку Войти на странице регистрации")
    public void loginUserByEnterButtonRegistrationPageTest() {

        //Клик по кнопке Личный Кабинет
        btnPersonalAccountClick();

        //Клик по кнопке Зарегистрироваться на форме авторизации
        btnRegistrationLoginPageClick();

        //Клик по кнопке Войти
        btnEnterClick();

        //Проверка перехода на страницу Авторизации
        checkLoginUser();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Переход на страницу авторизации по клику на кнопку Войти на странице восстановления пароля")
    public void loginUserByEnterButtonForgotPasswordPageTest() {

        //Клик по кнопке Личный Кабинет
        btnPersonalAccountClick();

        //Клик по кнопке Восстановить пароль
        btnRecoverPasswordClick();

        //Клик по кнопке Войти
        btnEnterForgotPasswordPageClick();

        //Проверка перехода на страницу Авторизации
        checkLoginUser();
    }

    @Step("Клик по кнопке Личный Кабинет")
    public void btnPersonalAccountClick(){
        MainPageObj mainPageObj = new MainPageObj(initBrowser.getDriver());

        mainPageObj.clickBtnPersonalAccount();
    }

    @Step("Клик по кнопке Войти в аккаунт")
    public void btnEnterAccauntClick(){
        MainPageObj mainPageObj = new MainPageObj(initBrowser.getDriver());

        mainPageObj.clickBtnEnterAccount();
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void btnRegistrationLoginPageClick(){
        LoginPageObj loginPageObj = new LoginPageObj(initBrowser.getDriver());

        loginPageObj.clickBtnRegistration();
    }

    @Step("Клик по кнопке Войти")
    public void btnEnterClick(){
        RegistrationPageObj registrationPageObj = new RegistrationPageObj(initBrowser.getDriver());

        registrationPageObj.clickBtnEnter();
    }

    @Step("Клик по кнопке Восстановить пароль")
    public void btnRecoverPasswordClick(){
        LoginPageObj loginPageObj = new LoginPageObj(initBrowser.getDriver());

        loginPageObj.clickBtnRecoverPassword();
    }

    @Step("Клик по кнопке Войти")
    public void btnEnterForgotPasswordPageClick(){
        ForgotPasswordPageObj forgotPasswordPageObj = new ForgotPasswordPageObj(initBrowser.getDriver());

        forgotPasswordPageObj.clickBtnLogin();
    }

    @Step("Проверка перехода на страницу авторизации")
    public void checkLoginUser(){
        LoginPageObj loginPageObj = new LoginPageObj(initBrowser.getDriver());

        Assert.assertTrue(loginPageObj.isHeaderLogin());
    }

    @After
    public void CloseBrowser() {

        initBrowser.closeBrowser(accessToken);
    }
}
