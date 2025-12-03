package helpers;

import apiClient.ProductApiClient;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.products.Product;
import responseBodies.ProductsResponse;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductHelper {

    public static List<Product> getAllProducts() {
        Response res = ProductApiClient.getAllProducts();
        ProductsResponse productRes = res.as(ProductsResponse.class, ObjectMapperType.GSON);
        return productRes.getProducts();
    }

    public static Product findSortedProduct(
                                      String userType,
                                      String category,
                                      int skipCount) {

        return getAllProducts().stream()
                .filter(p -> p.isUserType(userType))
                .filter(p -> p.isCategory(category))
                .sorted(Comparator.comparing(Product::getPriceValue))
                .skip(skipCount)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
