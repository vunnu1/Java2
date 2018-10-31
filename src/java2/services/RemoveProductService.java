package java2.services;

import java2.db.Database;
import java2.domain.Product;

import java.util.Optional;

public class RemoveProductService {

    private Database database;

    public RemoveProductService(Database database) {
        this.database = database;
    }

    public boolean remove(String title) {
        Optional<Product> foundProduct = database.findProductByTitle(title);
        if (foundProduct.isPresent()) {
            Product product = foundProduct.get();
            return database.deleteProduct(product);
        } else {
            return false;
        }
    }

}
