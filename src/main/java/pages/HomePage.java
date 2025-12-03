package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import components.Navbar;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {
    private final Page page;
    public final Navbar navbar;
    public final Locator header;
    private final Locator consentBtn;

    public HomePage(Page page) {
        this.page = page;
        this.navbar = new Navbar(page);
        this.header = page.locator("h1:has-text('AutomationExercise')");
        this.consentBtn = page.locator("button[aria-label='Consent']");
        verifyHomePage();
        handleConsentIfPresent();
    }

    private void verifyHomePage() {
        assertThat(header.first()).isVisible();
    }

    private void handleConsentIfPresent() {
        if (consentBtn.isVisible()) {
            consentBtn.click();
        }
    }

    public LoginPage navigateToLoginPage() {
        navbar.navigateToLoginPage();
        return new LoginPage(page);
    }

    public ProductsPage navigateToProductsPage() {
        navbar.navigateToProductsPage();
        return new ProductsPage(page);
    }
}
