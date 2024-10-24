import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.praktikum.InitBrowser;
import ru.yandex.praktikum.PageObjects.MainPageObj;

import java.util.concurrent.TimeUnit;

public class BurgerIngredientsTypesTest {

    InitBrowser initBrowser;

    public BurgerIngredientsTypesTest() {
        initBrowser = new InitBrowser();

        initBrowser.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    @Description("Переход к разделу Начинки на главной странице")
    public void toFillingsSectionTest() {

        //Клик по разделу Начинки
        sectionFillingsClick();

        //Проверка отображения списка начинок
        checkListFillings();
    }

    @Test
    @DisplayName("Переход к разделу Булки")
    @Description("Переход к разделу Булки на главной странице")
    public void toBunsSectionTest() {

        //Клик по разделу Начинки
        sectionFillingsClick();

        //Клик по разделу Булки
        sectionBunsClick();

        //Проверка отображения списка булок
        checkListBuns();
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    @Description("Переход к разделу Соусы на главной странице")
    public void toSaucesSectionTest() {

        //Клик по разделу Начинки
        sectionFillingsClick();

        //Клик по разделу Соусы
        sectionSaucesClick();

        //Проверка отображения списка соусов
        checkListSauces();
    }

    @Step("Клик по разделу Начинки")
    public void sectionFillingsClick() {
        MainPageObj mainPageObj = new MainPageObj(initBrowser.getDriver());

        mainPageObj.clickSectionFillings();
    }

    @Step("Клик по разделу Булки")
    public void sectionBunsClick() {
        MainPageObj mainPageObj = new MainPageObj(initBrowser.getDriver());

        mainPageObj.clickSectionBuns();
    }

    @Step("Клик по разделу Соусы")
    public void sectionSaucesClick() {
        MainPageObj mainPageObj = new MainPageObj(initBrowser.getDriver());

        mainPageObj.clickSectionSauces();
    }

    @Step("Проверка отображения списка начинок")
    public void checkListFillings() {
        MainPageObj mainPageObj = new MainPageObj(initBrowser.getDriver());

        Assert.assertTrue(mainPageObj.isHeaderFillings());
    }

    @Step("Проверка отображения списка булок")
    public void checkListBuns() {
        MainPageObj mainPageObj = new MainPageObj(initBrowser.getDriver());

        Assert.assertTrue(mainPageObj.isHeaderBuns());
    }

    @Step("Проверка отображения списка соусов")
    public void checkListSauces() {
        MainPageObj mainPageObj = new MainPageObj(initBrowser.getDriver());

        Assert.assertTrue(mainPageObj.isHeaderSauces());
    }

    @After
    public void CloseBrowser() {

        initBrowser.closeBrowser();
    }
}
