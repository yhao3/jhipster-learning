package org.yhao3.jhipsterlearning.service.mapper;

import org.mapstruct.*;
import org.yhao3.jhipsterlearning.domain.Product;
import org.yhao3.jhipsterlearning.domain.ProductCategory;
import org.yhao3.jhipsterlearning.service.dto.ProductCategoryDTO;
import org.yhao3.jhipsterlearning.service.dto.ProductDTO;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {
    @Mapping(target = "productCategory", source = "productCategory", qualifiedByName = "productCategoryId")
    ProductDTO toDto(Product s);

    @Named("productCategoryId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProductCategoryDTO toDtoProductCategoryId(ProductCategory productCategory);
}
