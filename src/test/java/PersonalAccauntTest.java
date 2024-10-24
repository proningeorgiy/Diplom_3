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

public class PersonalAccauntTest {

    private static final String USERNAME = "Vasja";
    private static final String USEREMAIL = "testuser12345@yandex.ru";
    private static final String USERPASSWORD = "123456";

    InitBrowser initBrowser;

    public PersonalAccauntTest() {
        initBrowser = new InitBrowser();

        initBrowser.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Переход в Личный кабинет")
    @Description("Переход на страницу личного кабинета после авторизации пользователя")
    public void personalAccauntAuthorizationTest() {

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

        //Проверка перехода в личный кабинет
        checkPersonalAccaunt();

        initBrowser.getAccessTokenFromLocalStorage();
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

    @Step("Проверка перехода в личный кабинет")
    public void checkPersonalAccaunt() {
        PersonalAccauntPageObj personalAccauntPageObj = new PersonalAccauntPageObj(initBrowser.getDriver());

        Assert.assertTrue(personalAccauntPageObj.isButtonProfile());
    }

    @After
    public void CloseBrowser() {

        initBrowser.closeBrowser();
    }
}
