package org.yhao3.jhipsterlearning.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.yhao3.jhipsterlearning.domain.ProductCategory;

/**
 * Spring Data JPA repository for the ProductCategory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {}
