package github.bhattaditya.pms.service;

import github.bhattaditya.pms.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();
    Category getCategory(Long categoryId);
    Category getCategoryByName(String categoryName);
}
