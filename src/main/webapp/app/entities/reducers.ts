import productCategory from 'app/entities/product-category/product-category.reducer';
import product from 'app/entities/product/product.reducer';
import member from 'app/entities/member/member.reducer';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

const entitiesReducers = {
  productCategory,
  product,
  member,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
};

export default entitiesReducers;
