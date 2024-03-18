package pl.voytecg.ecommerce;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final UUID id;
    private final String name;
    private final String description;

    public Product(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return null;
    }

    public BigDecimal getPrice() {

        return null;
    }

    public void changePrice() {

    }
}
