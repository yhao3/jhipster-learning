package org.yhao3.jhipsterlearning.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link org.yhao3.jhipsterlearning.domain.ProductCategory} entity.
 */
@Schema(description = "The ProductCategory entity.\n@author yhao3")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProductCategoryDTO implements Serializable {

    private Long id;

    /**
     * product category name
     */
    @NotNull
    @Schema(description = "product category name", required = true)
    private String productCategoryName;

    @NotNull
    private Boolean isShow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductCategoryDTO)) {
            return false;
        }

        ProductCategoryDTO productCategoryDTO = (ProductCategoryDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, productCategoryDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductCategoryDTO{" +
            "id=" + getId() +
            ", productCategoryName='" + getProductCategoryName() + "'" +
            ", isShow='" + getIsShow() + "'" +
            "}";
    }
}
