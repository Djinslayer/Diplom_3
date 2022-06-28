import clients.UserClient;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import model.UserCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page.MainPage;
import page.RegisterPage;
import page.ResetPassPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static page.LoginPage.LOGIN_PAGE_URL;
import static page.MainPage.MAIN_PAGE_URL;
import static page.RegisterPage.REGISTRATION_PAGE_URL;
import static page.ResetPassPage.RESET_PASS_PAGE_URL;

public class LoginTest {

    User user;
    UserClient userClient;
    UserCredentials userCredentials;

    @Before
    public void setUp() {
        user = User.getRandom();
        userClient = new UserClient();
        userCredentials = new UserCredentials();
        userClient.createUser(user);
    }

    @After
    public void tearDown() {
        if (userClient.loginUser(UserCredentials.from(user)).extract().statusCode() == 200) {
            String accessToken = userClient.getTokenLoginUser(UserCredentials.from(user));
            userClient.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Проверка входа по кнопке 'Войти в аккаунт' на главной странице")
    public void checkSuccessLoginFromMainPageTest() {
        Selenide.open(MAIN_PAGE_URL, MainPage.class)
                .clickEnterAccountButton()
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickLoginButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Проверка входа на главной странице при нажатии на футер (кнопка 'Личный кабинет')")
    public void checkSuccessLoginFromProfilePageTest() {
        Selenide.open(MAIN_PAGE_URL, MainPage.class)
                .clickAccountButtonWithoutAuth()
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickLoginButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void checkSuccessLoginFromRegisterPageTest() {
        Selenide.open(REGISTRATION_PAGE_URL, RegisterPage.class)
                .clickLoginButton()
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickLoginButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void checkSuccessLoginFromResetPassPageTest() {
        Selenide.open(RESET_PASS_PAGE_URL, ResetPassPage.class)
                .clickLoginButton()
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickLoginButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Проверка выхода по кнопке 'Выйти' в личном кабинете")
    public void checkSuccessLogoutTest() {
        Selenide.open(MAIN_PAGE_URL, MainPage.class)
                .clickAccountButtonWithoutAuth()
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickLoginButton()
                .clickAccountButtonWithAuth()
                .clickExitButton();

        webdriver().shouldHave(url(LOGIN_PAGE_URL));
    }
}
