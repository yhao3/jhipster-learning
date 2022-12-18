import { IProductCategory } from 'app/shared/model/product-category.model';

export interface IProduct {
  id?: number;
  productName?: string;
  price?: number;
  stock?: number;
  productCategory?: IProductCategory | null;
}

export const defaultValue: Readonly<IProduct> = {};
