package github.bhattaditya.pms.service;

import github.bhattaditya.pms.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product newProduct, String  username);
    List<Product> getProducts();
    Product getProduct(Long productId);
    Product updateProduct(Long productId, Product changedProduct, String username);
    void deleteProduct(Long productId);
}
