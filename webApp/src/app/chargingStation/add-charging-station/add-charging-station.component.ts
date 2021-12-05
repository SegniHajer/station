import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ChargingStationService } from 'src/app/charging-station-service.service';

@Component({
  selector: 'app-add-charging-station',
  templateUrl: './add-charging-station.component.html',
  styleUrls: ['./add-charging-station.component.css']
})
export class AddChargingStationComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router, private chargingStationService: ChargingStationService) {
  }

  addForm!: FormGroup;
  geolocation!: GeolocationPosition;
  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [],
      zipCode: ['', Validators.required],
      geolocation: ['', Validators.required],
      longitude: ['', Validators.required],
      latitude: ['', Validators.required],
    });

  }

  onSubmit() {
    this.chargingStationService.addStation(this.addForm.value)
      .subscribe(data => {
        console.log(data);
        console.log(this.addForm.value.longitude);
        this.router.navigate(['list-stations']);
      });
  }

}

