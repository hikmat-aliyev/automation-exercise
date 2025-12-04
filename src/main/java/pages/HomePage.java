package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import components.Navbar;

public class HomePage {
    private final Page page;
    public final Navbar nav;
    public final Locator header;
    private final Locator consentBtn;

    public HomePage(Page page) {
        this.page = page;
        this.nav = new Navbar(page);
        this.header = page.locator("h1:has-text('AutomationExercise')");
        this.consentBtn = page.locator("button[aria-label='Consent']");
        handleConsentIfPresent();
    }

    private void handleConsentIfPresent() {
        if (consentBtn.isVisible()) {
            consentBtn.click();
        }
    }
}
