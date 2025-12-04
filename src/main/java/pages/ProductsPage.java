package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import components.CategoryMenu;
import components.Navbar;
import lombok.Data;

@Data
public class ProductsPage {
    private final Page page;
    public final Navbar navbar;
    public final CategoryMenu categoryMenu;

    private final Locator pageHeader;
    private final Locator viewCartLink;
    private final Locator productItemsTitle;

    public ProductsPage(Page page) {
        this.page = page;
        this.navbar = new Navbar(page);
        this.categoryMenu = new CategoryMenu(page);

        this.pageHeader = page.getByRole(AriaRole.HEADING,
                new Page.GetByRoleOptions().setName("All Products"));

        this.viewCartLink = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("View Cart"));

        this.productItemsTitle = page.locator(".features_items h2.title");
    }

    public void goToWomenCategory(String category) {
        categoryMenu.clickWomenSubcategory(category);
    }

    public ViewCartPage viewCart() {
        viewCartLink.click();
        return new ViewCartPage(page);
    }

    public boolean isOnCorrectCategory(String title) {
        return this.productItemsTitle.textContent().trim().equalsIgnoreCase(title);
    }


}