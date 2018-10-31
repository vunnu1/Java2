package java2.services;

import java2.db.Database;
import java2.domain.Product;

public class AddProductService {

    private Database database;

    public AddProductService(Database database) {
        this.database = database;
    }

    public void add(String title,
                    String description) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);

        database.addProduct(product);
    }

}
