package pl.voytecg.ecommerce.catalog;

import org.junit.jupiter.api.Test;
import pl.voytecg.ecommerce.catalog.Product;
import pl.voytecg.ecommerce.catalog.ProductCatalog;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductCatalogTest {
    @Test
    void itAllowsListingProducts() {
        ProductCatalog catalog;
        catalog = thereIsProductCatalog();

        List<Product> products = catalog.allProducts();

        assert products.isEmpty();
    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }

    @Test
    void itAllowsToAddProduct() {
        ProductCatalog catalog = thereIsProductCatalog();
        catalog.addProduct("Lego set 8084","nice one");

        List<Product> allProducts = catalog.allProducts();
        assertThat(allProducts)
                .hasSize(1);
    }
    @Test
    void itLoadsSingleProductById() {
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.addProduct("Lego set 8084","nice one");

        Product loaded = catalog.getProductBy(id);

        assertThat(loaded.getId())
                .isEqualTo(id);

    }
    @Test
    void itAllowsToAssignOrChangePrice() {
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.addProduct("Lego set 8084","nice one");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));

        Product loaded = catalog.getProductBy(id);

        assertThat(loaded.getPrice())
                .isEqualTo(BigDecimal.valueOf(10.10));
    }

    @Test
    void itAllowsToAssignImage() {
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.addProduct("Lego set 8084","nice one");

        catalog.assignImage(id, "nice_image.jpeg");

        Product loaded = catalog.getProductBy(id);
        assertEquals("nice_image.jpeg", loaded.getImage());
    }

}
