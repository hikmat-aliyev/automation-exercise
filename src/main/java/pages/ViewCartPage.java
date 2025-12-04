package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Data;
import utils.WaitUtils;

@Data
public class ViewCartPage {
    private final Page page;

    private final Locator cartProduct;
    private final Locator proceedToCheckoutBtn;

    public ViewCartPage(Page page) {
        this.page = page;
        this.cartProduct = page.locator(".cart_description h4 a");
        this.proceedToCheckoutBtn = page.locator("a.check_out");;
    }

    public CheckoutPage proceedToCheckout() {
        proceedToCheckoutBtn.click();
        return new CheckoutPage(page);
    }

    public boolean verifyProductInBasket(String productName) {
        return this.cartProduct.textContent().trim().equalsIgnoreCase(productName);
    }

}
