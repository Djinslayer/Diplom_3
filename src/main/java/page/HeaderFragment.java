package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class HeaderFragment {

    // Кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = "//p[contains (text(), 'Конструктор')]")
    private SelenideElement btnConstructor;

    // Логотип "Stellar Burger"
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    // Кнопка "Личный кабинет"
    @FindBy(how = How.XPATH, using = "//p[contains (text(), 'Личный Кабинет')]")
    private SelenideElement btnAccount;


    @Step("Клик по кнопке 'Личный кабинет' (Пользователь не залогинен)")
    public LoginPage clickAccountButtonWithoutAuth() {
        btnAccount.click();
        return page(LoginPage.class);
    }

    @Step("Клик по кнопке 'Личный кабинет' (Пользователь залогинен)")
    public ProfilePage clickAccountButtonWithAuth() {
        btnAccount.click();
        return page(ProfilePage.class);
    }

    @Step("Клик по кнопке 'Конструктор'")
    public MainPage clickConstructorButton() {
        btnConstructor.click();
        return page(MainPage.class);
    }

    @Step("Клик по логотипу")
    public MainPage clickLogo() {
        logo.click();
        return page(MainPage.class);
    }
}
