import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AgmCoreModule } from '@agm/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddChargingStationComponent } from './chargingStation/add-charging-station/add-charging-station.component';
import { StationDetailsComponent } from './station-details/station-details.component';
import { StationListComponent } from './station-list/station-list.component';
import { from } from 'rxjs';

@NgModule({
  declarations: [
    AppComponent,
    AddChargingStationComponent,
    StationDetailsComponent,
    StationListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule, 
    AgmCoreModule.forRoot({
      libraries: ['places'],
      apiKey: 'AIzaSyAWj_3ixC6GwSTOOdapoHfHmbJnVdeuDQg'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
