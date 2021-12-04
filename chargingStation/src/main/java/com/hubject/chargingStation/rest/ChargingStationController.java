package com.hubject.chargingStation.rest;

import com.hubject.chargingStation.domain.ChargingStation;
import com.hubject.chargingStation.repository.ChargingStationRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin(origins = "http://localhost:4200")

public class ChargingStationController {

    @Autowired
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
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
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

    @ApiOperation(value = "Get chargingStation by geolocation", nickname = "getChargingStation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure") })
    @GetMapping(value = "/stations/geolocation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ChargingStation>> getChargingStationByGeoLocation(@RequestParam(value = "x", required = false) Double x,
                                                                                 @RequestParam(value = "y", required = false)Double y
                                                                                ) {
       Point geoLocation= new Point(x,y);
        List<ChargingStation> chargingStations =  chargingStationRepository.findByGeoLocation(geoLocation);
        if(chargingStations==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().body(chargingStations);
    }
}
