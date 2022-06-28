package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private String email;
    private String password;
    private String name;

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public static User getRandom() {
        final String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        final String password = RandomStringUtils.randomAlphabetic(6);
        final String name = RandomStringUtils.randomAlphabetic(10);
        return new User(email, password, name);
    }

    public static User getRandomWithPass5Symbols() {
        final String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        final String password = RandomStringUtils.randomAlphabetic(5);
        final String name = RandomStringUtils.randomAlphabetic(10);
        return new User(email, password, name);
    }
}
