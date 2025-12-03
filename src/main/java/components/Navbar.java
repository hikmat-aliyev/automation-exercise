package components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.LoginPage;

public class Navbar {
    private final Locator homeBtn ;
    private final Locator productsBtn;
    private final Locator cartBtn;
    private final Locator loginBtn;

    public Navbar(Page page) {
        this.homeBtn = page.locator("a[href='/']");
        this.productsBtn = page.locator("a[href='/products']");
        this.cartBtn = page.locator("a[href='/view_cart']");
        this.loginBtn = page.locator("a[href='/login']");
    }

    public void navigateToLoginPage() {
        loginBtn.click();
    }

    public void navigateToHomepage() {
        homeBtn.click();
    }

    public void navigateToShoppingCart() {
        cartBtn.click();
    }

    public void navigateToProductsPage() {
        productsBtn.click();
    }
}
