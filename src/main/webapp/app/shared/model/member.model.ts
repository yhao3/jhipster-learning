import { Sex } from 'app/shared/model/enumerations/sex.model';

export interface IMember {
  id?: number;
  memberName?: string;
  sex?: Sex;
}

export const defaultValue: Readonly<IMember> = {};
