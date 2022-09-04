package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends HeaderFragment {

    // URL главной страницы
    final public static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    // Кнопка "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement btnEnterAccount;

    // Кнопка "Оформить заказ"
    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement btnOrder;

    // Поле "Булки"
    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    private SelenideElement spanBuns;

    // Поле "Соусы"
    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    private SelenideElement spanSauces;

    // Поле "Начинки"
    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    private SelenideElement spanMeats;

    // Элемент "Булки" - Флюоресцентная булка R2-D3
    @FindBy(how = How.XPATH, using = "//*[@src='https://code.s3.yandex.net/react/code/bun-01.png']")
    private SelenideElement elementBunR2D3;

    // Элемент "Соусa" - Соус Spicy-X
    @FindBy(how = How.XPATH, using = "//*[@src='https://code.s3.yandex.net/react/code/sauce-02.png']")
    private SelenideElement elementSauceSpicyX;

    // Элемент "Начинки" - Мясо бессмертных моллюсков Protostomia
    @FindBy(how = How.XPATH, using = "//*[@src='https://code.s3.yandex.net/react/code/meat-02.png']")
    private SelenideElement elementMeatProtostomia;

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public LoginPage clickEnterAccountButton() {
        btnEnterAccount.click();
        return page(LoginPage.class);
    }

    @Step("Выбор 'Булки'")
    public MainPage clickBunsSpan() {
        spanBuns.click();
        return this;
    }

    @Step("Выбор 'Соусы'")
    public MainPage clickSaucesSpan() {
        spanSauces.click();
        return this;
    }

    @Step("Выбор 'Начинки'")
    public MainPage clickMeatsSpan() {
        spanMeats.click();
        return this;
    }

    @Step("Отображение видов булок")
    public boolean isBunsDisplayed() {
        return elementBunR2D3.isDisplayed();
    }

    @Step("Отображение видов соусов")
    public boolean isSaucesDisplayed() {
        return elementSauceSpicyX.isDisplayed();
    }

    @Step("Отображение видов начинки")
    public boolean isMeatsDisplayed() {
        return elementMeatProtostomia.isDisplayed();
    }
}
