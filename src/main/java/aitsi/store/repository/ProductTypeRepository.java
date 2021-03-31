package aitsi.store.repository;

import aitsi.store.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    ProductType getById(long id);
}