package aitsi.store.repository;

import aitsi.store.entity.Product;
import aitsi.store.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductByProductType(ProductType productType);
}
