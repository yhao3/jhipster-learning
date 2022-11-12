package org.yhao3.jhipsterlearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yhao3.jhipsterlearning.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
