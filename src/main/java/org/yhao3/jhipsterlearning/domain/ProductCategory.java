package org.yhao3.jhipsterlearning.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * The ProductCategory entity.\n@author yhao3
 */
@Entity
@Table(name = "product_category")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "productcategory")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    /**
     * product category name
     */
    @NotNull
    @Column(name = "product_category_name", nullable = false)
    private String productCategoryName;

    @NotNull
    @Column(name = "is_show", nullable = false)
    private Boolean isShow;

    @OneToMany(mappedBy = "productCategory")
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties(value = { "productCategory" }, allowSetters = true)
    private Set<Product> products = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ProductCategory id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCategoryName() {
        return this.productCategoryName;
    }

    public ProductCategory productCategoryName(String productCategoryName) {
        this.setProductCategoryName(productCategoryName);
        return this;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public Boolean getIsShow() {
        return this.isShow;
    }

    public ProductCategory isShow(Boolean isShow) {
        this.setIsShow(isShow);
        return this;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        if (this.products != null) {
            this.products.forEach(i -> i.setProductCategory(null));
        }
        if (products != null) {
            products.forEach(i -> i.setProductCategory(this));
        }
        this.products = products;
    }

    public ProductCategory products(Set<Product> products) {
        this.setProducts(products);
        return this;
    }

    public ProductCategory addProduct(Product product) {
        this.products.add(product);
        product.setProductCategory(this);
        return this;
    }

    public ProductCategory removeProduct(Product product) {
        this.products.remove(product);
        product.setProductCategory(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductCategory)) {
            return false;
        }
        return id != null && id.equals(((ProductCategory) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductCategory{" +
            "id=" + getId() +
            ", productCategoryName='" + getProductCategoryName() + "'" +
            ", isShow='" + getIsShow() + "'" +
            "}";
    }
}
