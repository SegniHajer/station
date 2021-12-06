import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ChargingStationService } from 'src/app/charging-station-service.service';

@Component({
  selector: 'app-add-charging-station',
  templateUrl: './add-charging-station.component.html',
  styleUrls: ['./add-charging-station.component.css']
})
export class AddChargingStationComponent implements OnInit {
  geoCoder: any;
  address: any;

  constructor(private formBuilder: FormBuilder, private router: Router, private chargingStationService: ChargingStationService) {
  }

  addForm!: FormGroup;
  ngOnInit() {
    this.addForm= new FormGroup({
      id: new FormControl(''),
      zipCode:new FormControl(''),
      geoLocation: new FormGroup({
        x: new FormControl(''),
        y: new FormControl(''),
      })
    });

  }


  onSubmit() {

    this.chargingStationService.addStation(this.addForm.value)
      .subscribe(data => {
        console.log( "data");
        console.log(data);
        console.log(" this.geoLocation");

         this.router.navigate(['list-stations']);
      });
  }

}

