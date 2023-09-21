package petstore.api.utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    private static final Faker faker = new Faker();

    public static String getRandomUserName() {
        return faker.name().username();
    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword() {
        return faker.internet().password();
    }

    public static String getRandomPhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static Integer getRandomNumber() {
        return faker.number().numberBetween(0, 10);
    }
}
