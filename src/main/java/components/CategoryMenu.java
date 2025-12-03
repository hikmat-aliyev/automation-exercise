package components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CategoryMenu {
    private final Page page;
    private final Locator womenCategory;
    private final Locator menCategory;
    private final Locator kidsCategory;

    public CategoryMenu(Page page) {
        this.page = page;
        this.womenCategory = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Women"));
        this.menCategory = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Men"));
        this.kidsCategory = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Kids"));
    }

    public CategoryMenu expandWomen() {
        womenCategory.click();
        return this;
    }

    public void clickWomenSubcategory(String subcategory) {
        expandWomen();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions()
                        .setName(subcategory))
                .first()  // because "Dress" appears twice (Women & Kids)
                .click();
    }

    public void clickCategory(String mainCategory, String subCategory) {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(mainCategory)).click();
        if (subCategory != null && !subCategory.isEmpty()) {
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(subCategory)).first().click();
        }
    }
}
