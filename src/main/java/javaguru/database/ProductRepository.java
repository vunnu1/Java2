package javaguru.database;

import javaguru.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(Product product);

    Optional<Product> findByTitle(String title);

    boolean remove(Product product);
    
    List<Product> getAll();
    
}
