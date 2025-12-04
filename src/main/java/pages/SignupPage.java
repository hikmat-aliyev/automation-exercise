package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import testData.SignupData;

import java.util.List;
import java.util.Random;

public class SignupPage {
    private final Page page;

    private final Locator userName;
    private final Locator email;
    private final Locator password;
    private final Locator firstName;
    private final Locator lastName;
    private final Locator address;
    private final Locator country;
    private final Locator state;
    private final Locator city;
    private final Locator zipCode;
    private final Locator mobileNumber;
    private final Locator submitBtn;

    public SignupPage(Page page) {
        this.page = page;
        this.userName = page.locator("[data-qa='name']");
        this.email = page.locator("[data-qa='email']");
        this.password = page.locator("[data-qa='password']");
        this.firstName = page.locator("[data-qa='first_name']");
        this.lastName = page.locator("[data-qa='last_name']");
        this.address = page.locator("[data-qa='address']");
        this.country = page.locator("[data-qa='country']");
        this.state = page.locator("[data-qa='state']");
        this.city = page.locator("[data-qa='city']");
        this.zipCode = page.locator("[data-qa='zipcode']");
        this.mobileNumber = page.locator("[data-qa='mobile_number']");
        this.submitBtn = page.locator("[data-qa='create-account']");
    }

    public AccountCreatedPage registerUser(SignupData data) {
        userName.fill(data.userName);
        password.fill(data.password);
        firstName.fill(data.firstName);
        lastName.fill(data.lastName);
        address.fill(data.address);
        selectRandomCountry();
        state.fill(data.state);
        city.fill(data.city);
        zipCode.fill(data.zipCode);
        mobileNumber.fill(data.mobileNumber);

        submitBtn.click();
        return new AccountCreatedPage(page);
    }

    private void selectRandomCountry() {
        // Get all option values
        List<String> options = country.locator("option").allTextContents();

        // Pick a random option
        Random random = new Random();
        String randomCountry = options.get(random.nextInt(options.size()));
        country.selectOption(randomCountry);
    }

}
