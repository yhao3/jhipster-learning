package org.yhao3.jhipsterlearning.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.yhao3.jhipsterlearning.domain.Member;

/**
 * Spring Data JPA repository for the Member entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {}
