package responseBodies;

import lombok.Data;
import models.products.Product;

import java.util.List;

@Data
public class ProductsResponse {
    private int responseCode;
    private List<Product> products;
}