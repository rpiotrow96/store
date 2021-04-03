package aitsi.store.service.impl;

import aitsi.store.entity.Product;
import aitsi.store.entity.ProductType;
import aitsi.store.repository.ProductRepository;
import aitsi.store.repository.ProductTypeRepository;
import aitsi.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductTypeRepository productTypeRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public List<ProductType> getAllCategories() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType getProductTypeById(long categoryId) {
        return productTypeRepository.getById(categoryId);
    }

    @Override
    public List<Product> getProductsByCategory(long categoryId) {
        ProductType productType = productTypeRepository.getById(categoryId);
        return productRepository.getProductByProductType(productType);
    }

    @Override
    public Product getProductById(long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
