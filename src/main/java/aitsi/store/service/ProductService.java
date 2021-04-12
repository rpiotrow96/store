package aitsi.store.service;

import aitsi.store.entity.Product;
import aitsi.store.entity.ProductType;

import java.util.List;

public interface ProductService {
    List<ProductType> getAllCategories();

    ProductType getProductTypeById(long categoryId);

    List<Product> getProductsByCategory(long categoryId);
    Product getProductById(long productId);

    Product addProduct(Product product);

    void deleteProduct(Product product);
}
