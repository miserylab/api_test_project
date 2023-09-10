package petstore.api.utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    Faker faker = new Faker();

    public String getRandomUserName() {
        return faker.name().username();
    }

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomPassword() {
        return faker.internet().password();
    }

    public String getRandomPhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public Integer getRandomNumber() {
        return faker.number().numberBetween(0, 10);
    }
}
