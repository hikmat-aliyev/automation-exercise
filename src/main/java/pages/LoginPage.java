package pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {

    private final Page page;

    private final Locator signupName;
    private final Locator signupEmail;
    private final Locator signupBtn;

    public LoginPage(Page page) {
        this.page = page;
        this.signupName = page.locator("[data-qa='signup-name']");
        this.signupEmail = page.locator("[data-qa='signup-email']");
        this.signupBtn = page.locator("[data-qa='signup-button']");
        verifyLoginPage();
    }

    private void verifyLoginPage() {
        assertThat(signupEmail).isVisible();
        assertThat(signupBtn).isVisible();
        assertThat(signupName).isVisible();
    }

    public LoginPage enterSignupEmail(String email) {
        signupEmail.fill(email);
        return this;
    }

    public LoginPage enterSignupName(String name) {
        signupName.fill(name);
        return this;
    }

    public SignupPage clickSignupBtn() {
        signupBtn.click();
        return new SignupPage(page);
    }

}
