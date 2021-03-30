package aitsi.store.service.impl;

import aitsi.store.entity.Product;
import aitsi.store.repository.ProductRepository;
import aitsi.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
