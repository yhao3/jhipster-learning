import { IProduct } from 'app/shared/model/product.model';

export interface IProductCategory {
  id?: number;
  productCategoryName?: string;
  isShow?: boolean;
  products?: IProduct[] | null;
}

export const defaultValue: Readonly<IProductCategory> = {
  isShow: false,
};
