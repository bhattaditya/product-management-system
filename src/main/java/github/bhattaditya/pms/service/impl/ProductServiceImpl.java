package github.bhattaditya.pms.service.impl;

import github.bhattaditya.pms.entity.Category;
import github.bhattaditya.pms.entity.Product;
import github.bhattaditya.pms.entity.User;
import github.bhattaditya.pms.repository.ProductRepo;
import github.bhattaditya.pms.service.CategoryService;
import github.bhattaditya.pms.service.ProductService;
import github.bhattaditya.pms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryService categoryService;
    private final UserService userService;

    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(CategoryService categoryService, UserService userService, ProductRepo productRepo) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productRepo = productRepo;
    }

    @Override
    public Product saveProduct(Product newProduct, String username) {

        Category category = categoryService.getCategoryByName(newProduct.getCategory().getName());
        newProduct.setCategory(category);

        if (username != null) {
            User user = this.userService.getUserByUsername(username);
            newProduct.setUser(user);
        }
        this.productRepo.save(newProduct);

        return newProduct;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = this.productRepo.findAll();

        return products;
    }

    @Override
    public Product getProduct(Long productId) {

        Product product = this.productRepo
                            .findById(productId)
                            .orElseThrow(
                                    ()-> new IllegalStateException("Product with ID: " + productId + " not found.")
                            );
        return product;
    }

    @Override
    public Product updateProduct(Long productId, Product changedProduct, String username) {
        Product product = getProduct(productId);
        product.setName(changedProduct.getName());
        product.setPrice(changedProduct.getPrice());
        product.setQuantity(changedProduct.getQuantity());
        product.setCategory(changedProduct.getCategory());

        Product saveProduct = saveProduct(product, username);
        return saveProduct;
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = getProduct(productId);
        this.productRepo.delete(product);
    }
}
