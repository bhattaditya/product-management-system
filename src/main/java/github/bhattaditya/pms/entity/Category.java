package github.bhattaditya.pms.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_category")
public class Category {
    @Id
    private Long id;

    private String name;

    @Column(nullable = false)
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}