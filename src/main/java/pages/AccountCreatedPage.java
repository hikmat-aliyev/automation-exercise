package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import utils.WaitUtils;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AccountCreatedPage {

    private final Page page;

    // Locators
    private final Locator title;
    private final Locator message1;
    private final Locator message2;
    private final Locator continueBtn;

    public AccountCreatedPage(Page page) {
        this.page = page;
        this.title = page.locator("[data-qa='account-created']");
        this.message1 = page.locator("p:has-text('Congratulations! Your new account has been successfully created!')");
        this.message2 = page.locator("p:has-text('You can now take advantage of member privileges')");
        this.continueBtn = page.locator("[data-qa='continue-button']");

        WaitUtils.waitForVisibility(title, message1, message1, continueBtn);
    }

    public HomePage clickContinue() {
        continueBtn.click();
        return new HomePage(page);
    }
}
