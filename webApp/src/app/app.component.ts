import { MapsAPILoader } from '@agm/core';
import { Component, ElementRef, NgZone, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ChargingStationService } from './charging-station-service.service';
import { ChargingStation } from './ChargingStation';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit  {
  zoom: number = 8;

 // initial center position for the map
 // initial center position for the map
  latitude!: number;
  longitude!: number;
  stations: ChargingStation[] = [];
  private geoCoder!: google.maps.Geocoder;
  address!: String;

  constructor(private router: Router, private chargingStationService: ChargingStationService, private mapsAPILoader: MapsAPILoader, private ngZone: NgZone) {
  }
  @ViewChild('search')
  public searchElementRef!: ElementRef;

    getStations() {
      this.chargingStationService.getStations().subscribe((data: ChargingStation[]) => {
        this.stations = data;
      });
    }
  
    ngOnInit(): void {
      this.router.events.subscribe((value: any) => {
        this.getStations();
        this.mapsAPILoader.load().then(() => {
          this.setCurrentLocation();
          this.geoCoder = new google.maps.Geocoder;
          
       //   let autocomplete = new window['google']['maps']['places']['Autocomplete'](this.searchElementRef.nativeElement);
           
         let autocomplete = new google.maps.places.Autocomplete(this.searchElementRef.nativeElement);
          autocomplete.addListener("place_changed", () => {
            this.ngZone.run(() => {
              //get the place result
              let place: google.maps.places.PlaceResult = autocomplete.getPlace();
    
              //verify result
              if (place.geometry === undefined || place.geometry === null) {
                return;
              }
    
              //set latitude, longitude and zoom
              this.latitude = place.geometry.location.lat();
              this.longitude = place.geometry.location.lng();
              this.zoom = 12;
            });
          });
      });
    });
  }
    // Get Current Location Coordinates
    private setCurrentLocation() {
      if ('geolocation' in navigator) {
        navigator.geolocation.getCurrentPosition((position) => {
          this.latitude = position.coords.latitude;
          this.longitude = position.coords.longitude;
          this.zoom = 15;
        });
      }
    }
  addChargingStation(): void {
    this.router.navigate(['add-station'])
      .then((e) => {
        if (e) {
          console.log("Navigation is successful!");
        } else {
          console.log("Navigation has failed!");
        }
      });
  };
  
  markerDragEnd($event: google.maps.MouseEvent) {
    console.log($event);
    this.latitude = $event.latLng.lat();
    this.longitude = $event.latLng.lng();
    this.getAddress(this.latitude, this.longitude);
  }
  getAddress(latitude: any, longitude: any) {
    this.geoCoder.geocode({ 'location': { lat: latitude, lng: longitude } }, (results: { formatted_address: any; }[], status: string) => {
      console.log(results);
      console.log(status);
      if (status === 'OK') {
        if (results[0]) {
          this.zoom = 12;
          this.address = results[0].formatted_address;
        } else {
          window.alert('No results found');
        }
      } else {
        window.alert('Geocoder failed due to: ' + status);
      }

    });
  }

}
