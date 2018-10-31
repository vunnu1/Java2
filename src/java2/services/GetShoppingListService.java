package java2.services;

import java2.db.Database;
import java2.domain.Product;

import java.util.List;

public class GetShoppingListService {
    
    private Database database;

    public GetShoppingListService(Database database) {
        this.database = database;
    }
    
    public List<Product> getAllProducts() {
        return database.getAllProducts();
    }
    
}
