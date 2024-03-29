package github.bhattaditya.pms.repository;

import github.bhattaditya.pms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
