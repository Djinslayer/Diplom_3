package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class ForgotPassPage extends HeaderFragment{

    public static final String FORGOT_PASS_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    // Кнопка "Восстановить"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Восстановить')]")
    private SelenideElement btnRecover;

    // Кнопка "Войти"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Войти')]")
    private SelenideElement btnLogin;


    @Step("Клик по кнопке 'Восстановить'")
    public ResetPassPage clickRecoverButton() {
        btnRecover.click();
        return page(ResetPassPage.class);
    }

    @Step("Клик по кнопке 'Войти'")
    public LoginPage clickLoginButton () {
        btnLogin.click();
        return page(LoginPage.class);
    }
}
