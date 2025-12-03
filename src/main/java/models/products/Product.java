package models.products;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Product {
    private int id;
    private String name;
    private String price;
    private String brand;
    private Category category;

    public int getPriceValue() {
        if (price == null) return 0;
        return Integer.parseInt(price.replace("Rs.", "").trim());
    }

    public boolean isUserType(String userType) {
        return category.isUsertype(userType);
    }

    public boolean isCategory(String categoryArg) {
        return category.getCategory().equals(categoryArg);
    }
}
