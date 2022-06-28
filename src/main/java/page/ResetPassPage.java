package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class ResetPassPage extends HeaderFragment{

    public static final String RESET_PASS_PAGE_URL = "https://stellarburgers.nomoreparties.site/reset-password";

    // Кнопка "Войти"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Войти')]")
    private SelenideElement btnLogin;


    @Step("Клик по кнопке 'Войти'")
    public LoginPage clickLoginButton () {
        btnLogin.click();
        return page(LoginPage.class);
    }
}
