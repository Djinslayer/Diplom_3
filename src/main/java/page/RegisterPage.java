package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class RegisterPage extends HeaderFragment{

    public static final String REGISTRATION_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    // Поле "Имя"
    @FindBy(how = How.XPATH, using = "//fieldset[1]//input")
    private SelenideElement inputName;

    // Поле "Email"
    @FindBy(how = How.XPATH, using = "//fieldset[2]//input")
    private SelenideElement inputEmail;

    // Поле "Пароль"
    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    private SelenideElement inputPass;

    // Кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement btnRegister;

    // Кнопка "Войти"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Войти')]")
    private SelenideElement btnLogin;

    // Ошибка "Некорректный пароль"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Некорректный пароль')]")
    private SelenideElement fieldErrorPass;


    @Step("Ввести имя")
    public RegisterPage inputName(String name) {
        inputName.setValue(name);
        return this;
    }

    @Step("Ввести Email")
    public RegisterPage inputEmail(String email) {
        inputEmail.setValue(email);
        return this;
    }

    @Step("Ввести пароль")
    public RegisterPage inputPass(String password) {
        inputPass.setValue(password);
        return this;
    }

    @Step("Клик по кнопке 'Зарегистрироваться' при успешной регистрации")
    public LoginPage clickRegisterButton() {
        this.btnRegister.click();
        return page(LoginPage.class);
    }

    @Step("Клик по кнопке 'Зарегистрироваться' при успешной регистрации")
    public RegisterPage clickRegisterButtonWithErrorPass() {
        this.btnRegister.click();
        return this;
    }

    @Step("Клик по кнопке 'Войти'")
    public LoginPage clickLoginButton() {
        btnLogin.click();
        return page(LoginPage.class);
    }

    @Step("Отображение ошибки 'Некорректный пароль'")
    public boolean isErrorPassFieldDisplayed() {
        return fieldErrorPass.isDisplayed();
    }
}
