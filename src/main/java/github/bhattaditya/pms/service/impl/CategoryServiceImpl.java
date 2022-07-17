package github.bhattaditya.pms.service.impl;

import github.bhattaditya.pms.entity.Category;
import github.bhattaditya.pms.repository.CategoryRepo;
import github.bhattaditya.pms.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        return categories;
    }

    @Override
    public Category getCategory(Long categoryId) {
        Category category = this.categoryRepo
                            .findById(categoryId)
                            .orElseThrow(
                                    ()-> new IllegalStateException("Category ID: " + categoryId + " not found.")
                            );
        return category;
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        Category category = this.categoryRepo.findByName(categoryName);
        return category;
    }
}
