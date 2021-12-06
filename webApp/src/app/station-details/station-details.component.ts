import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ChargingStationService } from '../charging-station-service.service';
import { ChargingStation } from '../ChargingStation';

@Component({
  selector: 'app-station-details',
  templateUrl: './station-details.component.html',
  styleUrls: ['./station-details.component.css']
})
export class StationDetailsComponent implements OnInit {
  id!: number; 
  chargingStation!: ChargingStation; 
  constructor(private route:ActivatedRoute, private chargingStationService: ChargingStationService) { }

  ngOnInit(): void {
    this.id= this.route.snapshot.params['id'];
    this.chargingStation=new ChargingStation();
    this.chargingStationService.getStationById(this.id).subscribe(data =>{
      this.chargingStation=data;
    });
  }

}
