package org.yhao3.jhipsterlearning.service.mapper;

import org.mapstruct.*;
import org.yhao3.jhipsterlearning.domain.ProductCategory;
import org.yhao3.jhipsterlearning.service.dto.ProductCategoryDTO;

/**
 * Mapper for the entity {@link ProductCategory} and its DTO {@link ProductCategoryDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductCategoryMapper extends EntityMapper<ProductCategoryDTO, ProductCategory> {}
