package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CheckoutPage {
    private final Page page;

    private final Locator placeOrderBtn;

    public CheckoutPage(Page page) {
        this.page = page;
        this.placeOrderBtn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Place Order"));
    }

    public PaymentPage placeOrder() {
        placeOrderBtn.click();
        return new PaymentPage(page);
    }
}
