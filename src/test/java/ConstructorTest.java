import clients.UserClient;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import model.UserCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page.LoginPage;
import page.MainPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static junit.framework.TestCase.assertTrue;
import static page.LoginPage.LOGIN_PAGE_URL;
import static page.MainPage.MAIN_PAGE_URL;

public class ConstructorTest {

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
    @DisplayName("Проверка отображения конструктора заказов при нажатии на 'Конструктор'")
    public void checkSuccessGoToConstructorChapterFromClickLogoTest() {
        Selenide.open(LOGIN_PAGE_URL, LoginPage.class)
                .clickLogo();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Проверка отображения конструктора заказов при нажатии на 'Конструктор'")
    public void checkSuccessGoToConstructorChapterFromClickConstructorButtonTest() {
        Selenide.open(LOGIN_PAGE_URL, LoginPage.class)
                .clickConstructorButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Булки'")
    public void checkSuccessGoToBunsSpanTest() {
        boolean isBunsDisplayed = Selenide.open(MAIN_PAGE_URL, MainPage.class)
                .clickAccountButtonWithoutAuth()
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickLoginButton()
                .clickMeatsSpan()
                .clickBunsSpan()
                .isBunsDisplayed();

        assertTrue("Должен отобразится раздел 'Булки'", isBunsDisplayed);
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Соусы'")
    public void checkSuccessGoToSaucesSpanTest() {
        boolean isSaucesDisplayed = Selenide.open(MAIN_PAGE_URL, MainPage.class)
                .clickAccountButtonWithoutAuth()
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickLoginButton()
                .clickSaucesSpan()
                .isSaucesDisplayed();

        assertTrue("Должен отобразится раздел 'Соусы'", isSaucesDisplayed);
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Начинки'")
    public void checkSuccessGoToMeatsSpanTest() {
        boolean isMeatsDisplayed = Selenide.open(MAIN_PAGE_URL, MainPage.class)
                .clickAccountButtonWithoutAuth()
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickLoginButton()
                .clickMeatsSpan()
                .isMeatsDisplayed();

        assertTrue("Должен отобразится раздел 'Начинки'", isMeatsDisplayed);
    }
}
