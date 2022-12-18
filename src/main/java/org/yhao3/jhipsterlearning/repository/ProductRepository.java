package org.yhao3.jhipsterlearning.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.yhao3.jhipsterlearning.domain.Product;

/**
 * Spring Data JPA repository for the Product entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
