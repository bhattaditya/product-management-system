package github.bhattaditya.pms.repository;

import github.bhattaditya.pms.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByName(String categoryName);
}
