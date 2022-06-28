package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePage extends HeaderFragment{

    public static final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    // Кнопка "Профиль"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Профиль')]")
    private SelenideElement btnProfile;

    // Кнопка "Выход"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Выход')]")
    private SelenideElement btnExit;

    @Step("Клик по кнопке 'Профиль'")
    public boolean isBtnProfileDisplayed() {
        return btnProfile.isDisplayed();
    }

    @Step("Клик по кнопке 'Выход'")
    public LoginPage clickExitButton() {
        btnExit.click();
        return page(LoginPage.class);
    }
}
