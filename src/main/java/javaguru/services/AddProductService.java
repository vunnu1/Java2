package javaguru.services;

import java2.database.ProductRepository;
import javaguru.domain.Product;

public class AddProductService {

    private ProductRepository database;

    public AddProductService(ProductRepository database) {
        this.database = database;
    }

    public void add(String title,
                    String description) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);

        database.save(product);
    }

}
