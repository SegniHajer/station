package com.hubject.chargingStation.rest;

import com.hubject.chargingStation.domain.ChargingStation;
import com.hubject.chargingStation.repository.ChargingStationRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class ChargingStationController {

    ChargingStationRepository chargingStationRepository;
    @GetMapping("/stations/")
    public Iterable<ChargingStation> getAllChargingStations() {
        return chargingStationRepository.findAll();
    }


    @ApiOperation(value = "Create a chargingStation", nickname = "createChargingStation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure") })
    @PostMapping(value = "/station/new",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChargingStation> createChargingStation(@RequestBody ChargingStation chargingStation){
        chargingStationRepository.save(chargingStation);
        return ResponseEntity.ok(null);
    }
    @ApiOperation(value = "Get chargingStation by id", nickname = "getChargingStation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure") })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChargingStation> getChargingStation(@PathVariable long id) {
        ChargingStation chargingStation = chargingStationRepository.findById(id);
        if(chargingStation==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().body(chargingStation);
    }


}
