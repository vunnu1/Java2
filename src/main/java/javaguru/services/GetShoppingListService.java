package javaguru.services;

import java2.database.ProductRepository;
import javaguru.domain.Product;

import java.util.List;



public class GetShoppingListService {

    private ProductRepository database;

    public GetShoppingListService(ProductRepository database) {
        this.database = database;
    }

    public List<Product> getAllProducts() {
        return database.getAll();
    }

}
