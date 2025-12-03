package pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import jdk.jpackage.internal.Log;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {

    private final Page page;

    private final Locator signupName;
    private final Locator signupEmail;
    private final Locator signupBtn;

    public LoginPage(Page page) {
        this.page = page;
        this.signupName = page.getByTestId("signup-name");
        this.signupEmail = page.getByTestId("signup-email");
        this.signupBtn = page.getByTestId("signup-button");
        verifyLoginPage();
    }

    private void verifyLoginPage() {
        assertThat(signupEmail).isVisible();
        assertThat(signupBtn).isVisible();
        assertThat(signupName).isVisible();
    }
}
