import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
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

public class DurgerIngredientsTypesTest {

    InitBrowser initBrowser;

    public DurgerIngredientsTypesTest() {
        initBrowser = new InitBrowser();

        initBrowser.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    @Description("Переход к разделу Соусы на главной странице")
    public void toSaucesSectionTest() throws InterruptedException {

        //Клик по кнопке Личный кабинет
        sectionSaucesClick();

        Thread.sleep(10000);

        //Проверка отображения списка соусов 
        //checkLoginUser();
    }

    @Step("Клик по разделу Соусы")
    public void sectionSaucesClick(){
        MainPageObj mainPageObj = new MainPageObj(initBrowser.getDriver());

        mainPageObj.clickSectionSauces();
    }

    @Step("Проверка перехода на страницу авторизации")
    public void checkLoginUser(){
        LoginPageObj loginPageObj = new LoginPageObj(initBrowser.getDriver());

        Assert.assertTrue(loginPageObj.isHeaderLogin());
    }

    @After
    public void CloseBrowser() {

        initBrowser.closeBrowser();
    }
}
