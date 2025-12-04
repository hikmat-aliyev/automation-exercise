package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Data;
import utils.WaitUtils;

@Data
public class AccountCreatedPage {

    private final Page page;

    // Locators
    private final Locator title;
    private final Locator successMsg;
    private final Locator message2;
    private final Locator continueBtn;

    public AccountCreatedPage(Page page) {
        this.page = page;
        this.title = page.locator("[data-qa='account-created']");
        this.successMsg = page.locator("p:has-text('Congratulations! Your new account has been successfully created!')");
        this.message2 = page.locator("p:has-text('You can now take advantage of member privileges')");
        this.continueBtn = page.locator("[data-qa='continue-button']");
    }

    public HomePage clickContinue() {
        continueBtn.click();
        return new HomePage(page);
    }

    public boolean isAccountCreatedSuccessfully() {
        return title.isVisible()
                && successMsg.isVisible()
                && continueBtn.isVisible()
                && title.textContent().equalsIgnoreCase("Account Created!");
    }
}
