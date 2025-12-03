package components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductCard {
    private final Page page;
    private final Locator addToCartBtn;

    public ProductCard(Page page, String productName) {
        this.page = page;
        // Locate product card container based on product name <p> text
        Locator root = page.locator(".productinfo").filter(new Locator.FilterOptions()
                        .setHasText(productName))
                .first();
        this.addToCartBtn = root.locator("a.add-to-cart");
    }

    public void addToCart() {
        addToCartBtn.click();
    }
}
