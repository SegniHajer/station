import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddChargingStationComponent } from './chargingStation/add-charging-station/add-charging-station.component';
import { SearchComponent } from './search/search.component';
import { StationDetailsComponent } from './station-details/station-details.component';
import { StationListComponent } from './station-list/station-list.component';

const routes: Routes = [
  {path: 'list-stations', redirectTo: '/', pathMatch: 'full'},
  {path: 'stations', component: StationListComponent},
  {path: 'add-station', component: AddChargingStationComponent},
  {path: 'search-station', component: SearchComponent},
  {path: 'chargingStation/:id', component: StationDetailsComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
  
})
export class AppRoutingModule { }