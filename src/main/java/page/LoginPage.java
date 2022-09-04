package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends HeaderFragment{

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    // Поле "Email"
    @FindBy(how = How.XPATH, using = "//input[@name ='name']")
    private SelenideElement inputEmail;

    // Поле "Пароль"
    @FindBy(how = How.XPATH, using = "//input[@name ='Пароль']")
    private SelenideElement inputPass;

    // Кнопка "Войти"
    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    private SelenideElement btnLogin;

    // Кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//a[@href='/register']")
    private SelenideElement btnRegister;

    // Кнопка "Восстановить пароль"
    @FindBy(how = How.XPATH, using = "//a[@href='/forgot-password']")
    private SelenideElement btnForgotPass;


    @Step("Ввести Email")
    public LoginPage inputEmail(String email){
        inputEmail.setValue(email);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage inputPass(String password) {
        inputPass.setValue(password);
        return this;
    }

    @Step("Клик по кнопке 'Войти'")
    public MainPage clickLoginButton() {
        btnLogin.click();
        return page(MainPage.class);
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public RegisterPage clickRegisterButton() {
        btnRegister.click();
        return page(RegisterPage.class);
    }

    @Step("Клик по кнопке 'Восстановить пароль'")
    public ForgotPassPage clickForgotPassButton() {
        btnForgotPass.click();
        return page(ForgotPassPage.class);
    }
}
