import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ChargingStationService } from '../charging-station-service.service';
import { ChargingStation } from '../ChargingStation';

@Component({
  selector: 'app-station-list',
  templateUrl: './station-list.component.html',
  styleUrls: ['./station-list.component.css']
})
export class StationListComponent implements OnInit {

  stations: ChargingStation[] | undefined;
  constructor(private router:Router,private  chargingStationService: ChargingStationService) { }

  ngOnInit(): void {
    this.getStations();
  }

  private getStations() {
    this.chargingStationService.getStations().subscribe(data=>{
      this.stations=data;
    });
  }

}
