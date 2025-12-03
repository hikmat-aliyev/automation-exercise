package testData;


import com.github.javafaker.Faker;

public class TestDataGenerator {
    private static final Faker faker = new Faker();

    public static String randomName() {
        return faker.name().firstName();
    }

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomPassword() {
        return faker.internet().password(5, 8);
    }

    public static String randomAddress() {
        return faker.address().streetAddress();
    }

    public static String randomCity() {
        return faker.address().city();
    }

    public static String randomZip() {
        return faker.address().zipCode();
    }

    public static String randomMobile() {
        return faker.phoneNumber().cellPhone();
    }

    public static String randomCountry() {
        return faker.country().name();
    }
}
