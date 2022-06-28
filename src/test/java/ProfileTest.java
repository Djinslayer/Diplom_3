import clients.UserClient;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import model.UserCredentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page.MainPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static page.MainPage.MAIN_PAGE_URL;
import static page.ProfilePage.PROFILE_PAGE_URL;

public class ProfileTest {

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
    @DisplayName("Проверка перехода по клику на 'Личный кабинет'")
    public void checkSuccessGoToProfilePageTest() {
        Selenide.open(MAIN_PAGE_URL, MainPage.class)
                .clickAccountButtonWithoutAuth()
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickLoginButton()
                .clickAccountButtonWithAuth();

        webdriver().shouldHave(url(PROFILE_PAGE_URL));
    }
}
