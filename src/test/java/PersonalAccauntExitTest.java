import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.praktikum.CreateUser.CreateUser;
import ru.yandex.praktikum.CreateUserApi;
import ru.yandex.praktikum.InitBrowser;
import ru.yandex.praktikum.PageObjects.LoginPageObj;
import ru.yandex.praktikum.PageObjects.MainPageObj;
import ru.yandex.praktikum.PageObjects.PersonalAccauntPageObj;

import java.util.concurrent.TimeUnit;

public class PersonalAccauntExitTest {

    private static final String USERNAME = "Vasja";
    private static final String USEREMAIL = "testuser12345@yandex.ru";
    private static final String USERPASSWORD = "123456";

    InitBrowser initBrowser;

    public PersonalAccauntExitTest() {
        initBrowser = new InitBrowser();

        initBrowser.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Выход из личного кабинета")
    @Description("Выход из личного кабинета по нажатию на кнопку Выход")
    public void personalAccauntExitTest() {

        CreateUser createUser = new CreateUser(USEREMAIL, USERPASSWORD, USERNAME);

        createUserWithResponse(createUser);

        //Клик по кнопке Личный кабинет
        btnPersonalAccountClick();

        //Заполнение полей на форме авторизации
        inputLoginData();

        //Клик по кнопке Войти
        btnLoginClick();

        //Клик по кнопке Личный кабинет
        btnPersonalAccountClick();

        initBrowser.getDriver().manage().window().maximize();
        initBrowser.getAccessTokenFromLocalStorage();

        //Клик по кнопке Выход
        btnExitClick();

        //Проверка перехода на страницу авторизации
        checkLoginUser();
    }

    @Step("Создание пользователя")
    public void createUserWithResponse(CreateUser createUser) {
        CreateUserApi createUserApi = new CreateUserApi(createUser);

        String accessToken;
        accessToken = createUserApi.createUser();

        initBrowser.setAccessToken(accessToken);
    }

    @Step("Клик по кнопке Личный Кабинет")
    public void btnPersonalAccountClick() {
        MainPageObj mainPageObj = new MainPageObj(initBrowser.getDriver());

        mainPageObj.clickBtnPersonalAccount();
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

    @Step("Клик по кнопке Выход")
    public void btnExitClick() {
        PersonalAccauntPageObj personalAccauntPageObj = new PersonalAccauntPageObj(initBrowser.getDriver());

        personalAccauntPageObj.clickBtnExit();
    }

    @Step("Проверка перехода на страницу авторизации")
    public void checkLoginUser() {
        LoginPageObj loginPageObj = new LoginPageObj(initBrowser.getDriver());

        Assert.assertTrue(loginPageObj.isHeaderLogin());
    }

    @After
    public void CloseBrowser() {

        initBrowser.closeBrowser();
    }
}
