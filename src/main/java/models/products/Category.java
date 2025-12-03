package models.products;

import lombok.Data;

@Data
public class Category {
    private UserType usertype;
    private String category;

    public boolean isUsertype(String userType) {
        return usertype.getUsertype().equals(userType);
    }
}