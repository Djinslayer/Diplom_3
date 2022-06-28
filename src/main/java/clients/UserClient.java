package clients;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import model.User;
import model.UserCredentials;

import static io.restassured.RestAssured.given;

public class UserClient extends RestAssuredClient {

    @Step("Регистрация пользователя")
    public ValidatableResponse createUser(User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
                .post("auth/register")
                .then();
    }

    @Step("Логин пользователя")
    public ValidatableResponse loginUser(UserCredentials userCredentials) {
        return given()
                .spec(getBaseSpec())
                .body(userCredentials)
                .post("auth/login")
                .then();
    }

    @Step("Получение токена после логина")
    public String getTokenLoginUser(UserCredentials userCredentials) {
        return given()
                .spec(getBaseSpec())
                .body(userCredentials)
                .post("auth/login")
                .then().extract().path("accessToken");
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String token) {
        return given()
                .headers("Authorization", token)
                .spec(getBaseSpec())
                .delete("auth/user")
                .then();
    }
}