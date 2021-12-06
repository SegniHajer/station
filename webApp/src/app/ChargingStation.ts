import { GeoPoint } from "./GeoPoint";

export class ChargingStation {
    id: number | undefined;
    zipCode: string | undefined;
    geoLocation!: GeoPoint;
  }