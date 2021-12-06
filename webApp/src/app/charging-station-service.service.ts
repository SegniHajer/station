import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { ChargingStation } from './ChargingStation';

@Injectable({
  providedIn: 'root'
})
export class ChargingStationService {

  private url = 'http://localhost:8080/';
 location!: GeolocationCoordinates;
  constructor(private http: HttpClient) {
  }

  getStations(): Observable<any> {
    return this.http.get(this.url+'stations/');
  }
  addStation(station: Object): Observable<Object> {
    const headers = { 'content-type': 'application/json'}  
    const body=JSON.stringify(station);
    console.log(body)
    return this.http.post(this.url, body,{'headers':headers})
  }
 
  //  return this.http.post(`${this.url}`, station);
 // }
  getStationById(id: number): Observable<ChargingStation>{
    return this.http.get<ChargingStation>(`${this.url}${id}`);
  }
  searchStationByZipCode(zipCode: String): Observable<ChargingStation> {
    return this.http.get<ChargingStation>(this.url+'/stations/zipCode');
  }
  
}