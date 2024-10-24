import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.praktikum.InitBrowser;
import ru.yandex.praktikum.PageObjects.LoginPageObj;
import ru.yandex.praktikum.PageObjects.MainPageObj;
import ru.yandex.praktikum.PageObjects.RegistrationPageObj;

import java.util.concurrent.TimeUnit;

public class RegistrationUserTest {

    private static final String USERNAME = "Vasja";
    private static final String USEREMAIL = "testuser12345@yandex.ru";
    private static final String USERPASSWORD = "123456";

    InitBrowser initBrowser;

    public RegistrationUserTest() {
        initBrowser = new InitBrowser();

        initBrowser.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Регистрация пользователя")
    @Description("Успешная регистрация пользователя")
    public void registrationTest() {

        //Клик по кнопке Личный Кабинет
        btnPersonalAccountClick();

        //Клик по кнопке Зарегистрироваться на форме авторизации
        btnRegistrationLoginPageClick();

        //Заполнение полей на форме регистрации
        inputRegistrationData(USERNAME, USEREMAIL, USERPASSWORD);

        //Клик по кнопке Зарегистрироваться
        btnRegistrationClick();

        //Заполнение полей на форме авторизации
        inputLoginData();

        //Клик по кнопке Войти
        btnLoginClick();

        //Проверка регистрации
        checkRegistration();

        initBrowser.getAccessTokenFromLocalStorage();
    }

    @Test
    @DisplayName("Регистрация пользователя, введен некорректный пароль")
    @Description("Сообщение об ошибке, если введен пароль менее 6 символов")
    public void registrationWrongPasswordTest() {

        //Клик по кнопке Личный Кабинет
        btnPersonalAccountClick();

        //Клик по кнопке Зарегистрироваться на форме авторизации
        btnRegistrationLoginPageClick();

        //Заполнение полей на форме регистрации
        inputRegistrationData(USERNAME, USEREMAIL, "12345");

        //Клик по кнопке Зарегистрироваться
        btnRegistrationClick();

        //Проверка появления сообщения об ошибке при вводе неверного пароля
        checkWrongPasswordMessage();
    }

    @Step("Клик по кнопке Личный Кабинет")
    public void btnPersonalAccountClick() {
        MainPageObj mainPageObj = new MainPageObj(initBrowser.getDriver());

        mainPageObj.clickBtnPersonalAccount();
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void btnRegistrationLoginPageClick() {
        LoginPageObj loginPageObj = new LoginPageObj(initBrowser.getDriver());

        loginPageObj.clickBtnRegistration();
    }

    @Step("Заполнение полей на форме регистрации")
    public void inputRegistrationData(String userName, String userEmail, String userPassword) {
        RegistrationPageObj registrationPageObj = new RegistrationPageObj(initBrowser.getDriver());

        registrationPageObj.setName(userName);
        registrationPageObj.setEmail(userEmail);
        registrationPageObj.setPassword(userPassword);
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void btnRegistrationClick() {
        RegistrationPageObj registrationPageObj = new RegistrationPageObj(initBrowser.getDriver());

        registrationPageObj.clickBtnRegistration();
    }

    @Step("Заполнение полей на форме авторизации")
    public void inputLoginData() {
        LoginPageObj loginPageObj = new LoginPageObj(initBrowser.getDriver());

        loginPageObj.setEmail(USEREMAIL);
        loginPageObj.setPassword(USERPASSWORD);
    }

    @Step("Клик по кнопке Войти")
    public void btnLoginClick() {
        LoginPageObj loginPageObj = new LoginPageObj(initBrowser.getDriver());

        loginPageObj.clickBtnLogin();

        initBrowser.getAccessTokenFromLocalStorage();
    }

    @Step("Проверка регистрации")
    public void checkRegistration() {
        MainPageObj mainPageObj = new MainPageObj(initBrowser.getDriver());

        Assert.assertTrue(mainPageObj.isHeaderCreateBurger());
    }

    @Step("Проверка появления сообщения о неверном пароле")
    public void checkWrongPasswordMessage() {
        RegistrationPageObj registrationPageObj = new RegistrationPageObj(initBrowser.getDriver());

        Assert.assertTrue(registrationPageObj.isWrongPassword());
    }

    @After
    public void CloseBrowser() {

        initBrowser.closeBrowser();
    }
}
